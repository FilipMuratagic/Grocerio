package com.example.grocerio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerio.database.DatabaseClient;
import com.example.grocerio.database.Items;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ExtendList extends AppCompatActivity {

    ArrayList<String> ItemName = new ArrayList<>();
    ArrayList<String> ItemQty = new ArrayList<>();
    int namevalue = 2000300;
    int qtyvalue = 2000400;
    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    int ListAmount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_list);

        Intent intent = getIntent();
        ArrayList<String> ItemNameAdded = intent.getStringArrayListExtra("data");
        ArrayList<String> ItemQtyAdded = intent.getStringArrayListExtra("data1");

        RecyclerView RecyclerViewMain = findViewById(R.id.RecyclerViewMain);

        final ItemsAdapter adapter = new ItemsAdapter(ItemNameAdded,ItemQtyAdded);
        RecyclerViewMain.setAdapter(adapter);
        RecyclerViewMain.setLayoutManager(new LinearLayoutManager(this));

        Button save_btn = findViewById(R.id.CreateListButton);
        save_btn.setOnClickListener(v -> {
            ArrayList<String> itemnames = adapter.getItemNameListTemp();
            ArrayList<String> itemqtys = adapter.getItemQtyListTemp();

            for(int i=0;i<60;i++) {
                if (!itemnames.get(i).equals("")) {
                    ItemName.add(itemnames.get(i).toUpperCase());
                    ItemQty.add(itemqtys.get(i));
                }
            }
            saveItems();
        });

    }

    private void saveItems(){

        @SuppressLint("StaticFieldLeak")
        class SaveItems extends AsyncTask<Void, Void, Void>{

            protected Void doInBackground(Void... voids){
                ListAmount = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getMaxListNo();
                ListAmount++;

                for(int i=0;i<ItemName.size();i++){

                    //we create the list one entry at a time
                    Items items = new Items();
                    items.setListNo(ListAmount);
                    items.setItemName(ItemName.get(i));
                    items.setItemQty(ItemQty.get(i));
                    items.setDate(date);

                    //write each item in the database, with the same List Number
                    DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().insert(items);
                }
                return null;
            }

            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                if(ItemName.size()!=0) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(getApplicationContext(), "Your Items List has been saved.", Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(), "You did not insert any items.", Toast.LENGTH_SHORT).show();
                System.out.println(ItemName.size());
            }
        }

        SaveItems saveitems = new SaveItems();
        saveitems.execute();
    }

}