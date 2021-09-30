package com.example.grocerio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grocerio.database.DatabaseClient;
import com.example.grocerio.database.Items;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CreateNewList extends AppCompatActivity {

    ArrayList<String> ItemName = new ArrayList<>();
    ArrayList<String> ItemQty = new ArrayList<>();
    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

    int[] itemId = new int[]{R.id.textView30,R.id.textView31,R.id.textView32,R.id.textView33,R.id.textView34,R.id.textView35,R.id.textView36,R.id.textView37,
                             R.id.textView38,R.id.textView39,R.id.textView40,R.id.textView41,R.id.textView42,R.id.textView43,R.id.textView44,R.id.textView48,
                             R.id.textView49,R.id.textView50,R.id.textView51,R.id.textView57,R.id.textView58,R.id.textView59,R.id.textView60,R.id.textView61,
                             R.id.textView62,R.id.textView63,R.id.textView64,R.id.textView65,R.id.textView67,R.id.textView68,R.id.textView69,R.id.textView70,R.id.textView71};

    int[] editId = new int[]{R.id.editText30,R.id.editText31,R.id.editText32,R.id.editText33,R.id.editText34,R.id.editText35,R.id.editText36,R.id.editText37,
                             R.id.editText38,R.id.editText39,R.id.editText40,R.id.editText41,R.id.editText42,R.id.editText43,R.id.editText44,R.id.editText48,
                             R.id.editText49,R.id.editText50,R.id.editText51,R.id.editText57,R.id.editText58,R.id.editText59,R.id.editText60,R.id.editText61,
                             R.id.editText62,R.id.editText63,R.id.editText64,R.id.editText65,R.id.editText67,R.id.editText68,R.id.editText69,R.id.editText70,R.id.editText71};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_list);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void onAddMoreItemsClicked(View view){

        for(int i=0; i<editId.length;i++){
            EditText T = findViewById(editId[i]);
            TextView TV = findViewById(itemId[i]);
            /*DataStore.set(i,T.getText().toString());*/
            if (!T.getText().toString().equals("")){
                ItemName.add(TV.getText().toString());
                ItemQty.add(T.getText().toString());
            }
        }
        Intent ExtendList = new Intent(this,ExtendList.class );
        ExtendList.putStringArrayListExtra("data",ItemName);
        ExtendList.putStringArrayListExtra("data1",ItemQty);

        startActivity(ExtendList);
    }

    public void onCreateQuickList(View view){

        for(int i=0; i<editId.length;i++){
            EditText T = findViewById(editId[i]);
            TextView TV = findViewById(itemId[i]);

            if (!T.getText().toString().equals("")){
                ItemName.add(TV.getText().toString());
                ItemQty.add(T.getText().toString());
            }
        }
        saveItems();
    }


    private void saveItems(){

        @SuppressLint("StaticFieldLeak")
        class SaveItems extends AsyncTask<Void, Void, Void> {

            protected Void doInBackground(Void... voids){
                int ListAmount = DatabaseClient.getInstance(getApplicationContext()).getAppDataBase().itemsDao().getMaxListNo();
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