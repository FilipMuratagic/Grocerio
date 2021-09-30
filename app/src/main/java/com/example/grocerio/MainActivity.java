package com.example.grocerio;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constrained);

        requestLocationPermission();
    }

    @Override
    public void onBackPressed(){
        //Override added due to issues with the back stack after deleting an ItemList in MyLists
        finishAffinity();
    }

    public void onNewListClicked(View view) {
        Intent CreateNewList = new Intent(this, CreateNewList.class);
        startActivity(CreateNewList);
    }

    public void onMyListsClicked(View view) {
        Intent MyLists = new Intent(this, MyLists.class);
        startActivity(MyLists);
    }

    public void onRecipesClicked(View view) {
        Intent Recipes = new Intent(this, Recipes.class);
        startActivity(Recipes);
    }

    public void onStatisticsClicked(View view) {
        Intent Statistics = new Intent(this, Statistics.class);
        startActivity(Statistics);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    public void requestLocationPermission() {
        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(this, perms)) {
            /*Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();*/
        }
        else {
            EasyPermissions.requestPermissions(this, "The Google Maps feature needs to use your location for a better app service. Please grant the location permission", REQUEST_LOCATION_PERMISSION, perms);
        }
    }


    /*private void dropTable(){
        class DropTable extends AsyncTask<Void,Void,Void>{
            protected Void doInBackground(Void... voids){
                DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().deleteAll();
                return null;
            }
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
            }
        }
        DropTable DT = new DropTable();
        DT.execute();
    }*/
}
