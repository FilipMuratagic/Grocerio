package com.example.grocerio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyListsEmptyAdapter extends RecyclerView.Adapter<MyListsEmptyAdapter.MyListsEmptyViewHolder> {

    private Context mCtx;

    public MyListsEmptyAdapter(Context mCtx){
        this.mCtx=mCtx;

    }

    public MyListsEmptyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(mCtx).inflate(R.layout.my_lists_empty_list,parent,false);
        return new MyListsEmptyViewHolder(view);
    }

    public void onBindViewHolder(MyListsEmptyViewHolder holder, int position){

        /*TextView tv1 = holder.textView1;
        */
    }

    public int getItemCount(){
        return 1;
    }

    class MyListsEmptyViewHolder extends RecyclerView.ViewHolder{

        TextView textView1;
        public MyListsEmptyViewHolder(View itemView){
            super(itemView);

            textView1=itemView.findViewById(R.id.textViewEmptyList1);
        }
    }
}
