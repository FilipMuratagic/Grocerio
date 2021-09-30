package com.example.grocerio;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerio.database.DatabaseClient;
import com.example.grocerio.database.Items;

import java.util.List;

public class OpenList extends AppCompatActivity {

    private RecyclerView recyclerView;
    int ListNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);
        Intent intent = getIntent();
        int ListNo = intent.getIntExtra("data",0);
        ListNr = ListNo;
        TextView TV = findViewById(R.id.textViewOpenList);
        TV.setText("List #" + ListNo);

        recyclerView = findViewById(R.id.RecyclerViewOpenList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new GetListItems().execute(ListNo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.delete_menu){
            AlertDialog.Builder builder = new AlertDialog.Builder(OpenList.this);
            builder.setTitle("Delete List #" + ListNr + " ?");
            builder.setMessage("Are you sure you want to delete List #" + ListNr +" ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new DeleteItems().execute(ListNr);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("StaticFieldLeak")
    private class GetListItems extends AsyncTask<Integer,Void, List<Items>>{

        @Override
        protected List<Items> doInBackground(Integer... params){
            int ListNumber = params[0];
            return DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getAllItems(ListNumber);
        }

        @Override
        protected void onPostExecute(List<Items> itemsList){
            super.onPostExecute(itemsList);
            OpenListAdapter olAdapter = new OpenListAdapter(OpenList.this,itemsList);
            recyclerView.setAdapter(olAdapter);
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class DeleteItems extends AsyncTask<Integer,Void, Void>{

        @Override
        protected Void doInBackground(Integer... params){
            /*int ListAmount = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getMaxListNo();*/
            int ListNumber = params[0];
            List<Items> itemsList = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getAllItems(ListNumber);
            List<Items> updateList = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getItemsToUpdate(ListNumber);

            for(int i=0;i<itemsList.size();i++){
                Items items = itemsList.get(i);
                DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().delete(items);
            }

            for(int j=0;j<updateList.size();j++){
                Items items = updateList.get(j);
                int temp = items.getListNo();
                items.setListNo(temp-1);
                DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().update(items);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            finish();
            startActivity(new Intent(getApplicationContext(),MyLists.class));
            Toast.makeText(getApplicationContext(), "List deleted.",Toast.LENGTH_LONG).show();
        }

    }

}