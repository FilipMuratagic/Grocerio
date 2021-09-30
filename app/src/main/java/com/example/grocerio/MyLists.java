package com.example.grocerio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerio.database.DatabaseClient;
import com.example.grocerio.database.Items;

import java.util.List;

public class MyLists extends AppCompatActivity {

    private RecyclerView recyclerView;
    int number;
    int imageID = 2100800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lists);
        recyclerView = findViewById(R.id.RecyclerViewMyLists);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        getListNumbers();
    }

    @Override
    public void onBackPressed(){
        //Override added due to issues with the back stack after deleting an ItemList in MyLists
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void onListSpecificClicked(View view){
        int id = view.getId() - imageID;
        /*System.out.println(id);*/
        Intent OpenList = new Intent(this,OpenList.class);
        OpenList.putExtra("data",id);
        startActivity(OpenList);
    }

    private void getListNumbers(){
        @SuppressLint("StaticFieldLeak")
        class GetListNumbers extends AsyncTask<Void,Void, List<Items>>{

            @Override
            protected List<Items> doInBackground(Void... voids){
                int ListAmount = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getMaxListNo();
                number = ListAmount;
                List<Items> itemsList;
                if (ListAmount!=0){
                    itemsList = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getDateList();
                }
                else {
                    itemsList = null;
                }
                return itemsList;
            }

            @Override
            protected void onPostExecute(List<Items> itemsList){
                super.onPostExecute(itemsList);
                if (number==0){
                    MyListsEmptyAdapter emptyAdapter = new MyListsEmptyAdapter(MyLists.this);
                    recyclerView.setAdapter(emptyAdapter);
                }
                else {
                    MyListsAdapter adapter = new MyListsAdapter(MyLists.this,itemsList);
                    recyclerView.setAdapter(adapter);
                    /*number=itemsList.size();*/
                }
            }
        }
        GetListNumbers gln = new GetListNumbers();
        gln.execute();
    }

}