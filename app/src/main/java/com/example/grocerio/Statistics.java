package com.example.grocerio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.grocerio.database.DatabaseClient;
import com.example.grocerio.database.Items;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Statistics extends AppCompatActivity implements OnMapReadyCallback {

    List<Items> ItemList = null;

    private static final String TAG = Statistics.class.getSimpleName();

    /*private static final int REQUEST_LOCATION_PERMISSION = 1;
    public static final float INITIAL_ZOOM = 12f;*/
    private GoogleMap mMap;
    private CameraPosition cameraPosition;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    private final LatLng defaultLocation = new LatLng(45.464664, 9.188540);
    private static final int DEFAULT_ZOOM = 14;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean locationPermissionGranted;

    private Location lastKnownLocation;

    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";

    DBContent dbContent = new DBContent();


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
            cameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
        }

        setContentView(R.layout.activity_statistics);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mapView, mapFragment).commit();
        mapFragment.getMapAsync(this);

        mFusedLocationProviderClient = LocationServices
                .getFusedLocationProviderClient(this);

        final ScrollView scroll = findViewById(R.id.scroll);
        ImageView transparent = findViewById(R.id.imagetrans);

        transparent.setOnTouchListener((v, event) -> {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    // Disallow ScrollView to intercept touch events.
                    scroll.requestDisallowInterceptTouchEvent(true);
                    // Disable touch on transparent view
                    return false;

                case MotionEvent.ACTION_UP:
                    // Allow ScrollView to intercept touch events.
                    scroll.requestDisallowInterceptTouchEvent(false);
                    return true;

                case MotionEvent.ACTION_MOVE:
                    scroll.requestDisallowInterceptTouchEvent(true);
                    return false;

                default:
                    return true;
            }
        });


        ItemList = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getAll();

        dbContent.delegate = this::setItemList;
        dbContent.execute();


        BarChart barChart = findViewById(R.id.BarChart);
        PieChart pieChart = findViewById(R.id.PieChart);

        BarDataSet dataSet = new BarDataSet(BarInputs(), "Items");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10f);

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.6f);
        ValueFormatter xAxisFormatter = new ItemAxisValueFormatter(barChart);
        XAxis xAxisBar = barChart.getXAxis();
        xAxisBar.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisBar.setDrawGridLines(false);
        xAxisBar.setGranularity(0.5f);
        xAxisBar.setLabelCount(ItemList.size());
        xAxisBar.setLabelRotationAngle(-90);
        xAxisBar.setValueFormatter(xAxisFormatter);

        barChart.setData(barData);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(20);
        barChart.animateY(1500);
        barChart.invalidate();

        PieDataSet pieDataSet = new PieDataSet(PieInputs(), "Items");
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(12f);
        pieDataSet.setFormSize(5f);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setEntryLabelTextSize(8f);
        pieChart.animateY(1500);
        pieChart.setCenterText("Percentage(%) of Items");
        pieChart.setCenterTextSize(14);
        pieChart.setExtraBottomOffset(10f);
        pieChart.setExtraLeftOffset(10f);
        pieChart.setExtraRightOffset(10f);
        pieChart.setUsePercentValues(true);
        pieChart.invalidate();

    }

    public ArrayList<BarEntry> BarInputs() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < ItemList.size(); i++) {
            Items items;
            items = ItemList.get(i);
            if (!items.getItemQty().equals("")) {
                float qty = Float.parseFloat(items.getItemQty());
                entries.add(i, new BarEntry(i, qty));
            }else{
                entries.add(i,new BarEntry(i,0));
            }
        }
        return entries;
    }

    public ArrayList<PieEntry> PieInputs() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        List<Items> copyList = ItemList;
        List<Items> checkList = new ArrayList<>();
        if (copyList.size()!=0){
            checkList.add(0, copyList.get(0));
        }else checkList = null;
        int total = 0;
        for (int i = 0; i < ItemList.size(); i++) {
            Items items;
            int flag = 0;
            /*if(!checkList.isEmpty()){*/

            for (int j = 0; j < checkList.size(); j++) { // change loop to check for all items in checklist instead
                Items item = copyList.get(i);
                Items check = checkList.get(j); // i-1
                if (item.getItemName().equals(check.getItemName())) {
                    if(item.getItemQty().equals("")){
                        item.setItemQty("0");
                    }
                    int add = Integer.parseInt(item.getItemQty());
                    int checkInt = Integer.parseInt(check.getItemQty());
                    checkInt += add;
                    check.setItemQty(String.valueOf(checkInt));
                } else {
                    flag++;
                    if (flag == checkList.size())
                        checkList.add(copyList.get(i));
                }
            }

            items = ItemList.get(i);
            total += Integer.parseInt(items.getItemQty());
        }
        if (checkList != null) {
            for (int i = 0; i < checkList.size(); i++) {
                Items items1;
                items1 = checkList.get(i);
                float qty = Float.parseFloat(items1.getItemQty());
                entries.add(i, new PieEntry((qty / total) * 100, items1.getItemName()));
            }
        }else entries.add(0,new PieEntry(0,"Empty Element"));
        return entries;
    }


    void processFinish(List<Items> itemsList){

    }


    public class ItemAxisValueFormatter extends ValueFormatter {
        private final BarLineChartBase<?> chart;

        public ItemAxisValueFormatter(BarLineChartBase<?> chart) {
            this.chart = chart;
        }

        @Override
        public String getFormattedValue(float value) {
            Items items = ItemList.get(Math.round(value));
            return items.getItemName();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mMap != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, mMap.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, lastKnownLocation);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        locationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        /*enableMyLocation(mMap);*/

        getLocationPermission();

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();

    }


    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (locationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                lastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            if (locationPermissionGranted) {
                Task<Location> locationResult = mFusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Set the map's camera position to the current location of the device.
                        lastKnownLocation = task.getResult();
                        if (lastKnownLocation != null) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(lastKnownLocation.getLatitude(),
                                            lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                        }
                    } else {
                        Log.d(TAG, "Current location is null. Using defaults.");
                        Log.e(TAG, "Exception: %s", task.getException());
                        mMap.moveCamera(CameraUpdateFactory
                                .newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
                        mMap.getUiSettings().setMyLocationButtonEnabled(false);
                    }
                });
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage(), e);
        }
    }

    public void setItemList(List<Items> itemList){
        this.ItemList = itemList;
    }

    public interface AsyncResponse{
        void processFinish(List<Items> itemsList);
    }

    public class DBContent extends AsyncTask<Void,Void, List<Items>>{


        public AsyncResponse delegate = null;

        @Override
        protected List<Items> doInBackground(Void... voids){
            List<Items> itemsList;
            itemsList = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getAll();
            return itemsList;
        }

        @Override
        protected void onPostExecute(List<Items> itemsList){
            super.onPostExecute(itemsList);
            Statistics.this.setItemList(itemsList);
            delegate.processFinish(itemsList);
        }
    }


}