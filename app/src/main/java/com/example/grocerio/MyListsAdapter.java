package com.example.grocerio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerio.database.Items;

import java.util.List;

public class MyListsAdapter extends RecyclerView.Adapter<MyListsAdapter.MyListsViewHolder> {

    private Context mCtx;
    private List<Items> itemsList;
    private int imageID = 2100800;

    public MyListsAdapter(Context mCtx,List<Items> itemsList){
        this.mCtx=mCtx;
        this.itemsList=itemsList;
    }

    public MyListsViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(mCtx).inflate(R.layout.my_lists_populate,parent,false);
        return new MyListsViewHolder(view);
    }

    public void onBindViewHolder(MyListsViewHolder holder,int position){

        Items I = itemsList.get(position);
        holder.textViewListNo.setText("List #" + I.getListNo()); //check order of execution here - R.string.ListNoAdapter
        holder.textViewDate.setText(I.getDate());
        holder.itemImage.setId(imageID + position + 1);

    }

    public int getItemCount(){
        if(itemsList!=null){
        return itemsList.size();}
        else return 0;
    }


    class MyListsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewListNo, textViewDate;
        ImageView itemImage;

        public MyListsViewHolder(View itemView){
            super(itemView);
            itemImage = itemView.findViewById(R.id.ImageViewMyList);
            textViewListNo = itemView.findViewById(R.id.TextViewListNumber);
            textViewDate = itemView.findViewById(R.id.TextViewDateCreated);
        }
    }
}
