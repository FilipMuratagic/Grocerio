package com.example.grocerio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerio.database.Items;

import java.util.List;

public class OpenListAdapter extends RecyclerView.Adapter<OpenListAdapter.OpenListViewHolder>{

    private final Context mCtx;
    private final List<Items> itemsList;

    public OpenListAdapter(Context mCtx,List<Items> itemsList){

        this.mCtx=mCtx;
        int size = itemsList.size();
        int sizeHelper = 0;
        if (size < 23) sizeHelper =23 - size;

        for (int j=size; j<size+sizeHelper; j++){ //check this value after setting ItemsAdapter to be a static number of fields instead of an inflater
            Items I = new Items(); //if size is less than 23(number of textViews that fit on the screen), add the remaining textViews
            I.setItemName("");
            I.setItemQty("");
            itemsList.add(j,I);
        }
        this.itemsList=itemsList;
    }
    public OpenListAdapter.OpenListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mCtx).inflate(R.layout.open_list_populate,parent,false);
        return new OpenListAdapter.OpenListViewHolder(view);
    }

    public void onBindViewHolder(OpenListViewHolder holder, int position){

        String number = Integer.toString(position+1);
        Items I = itemsList.get(position);
        holder.textViewNo.setText(number + ".");
        holder.textViewListName.setText(I.getItemName());
        holder.textViewListQty.setText(I.getItemQty());
    }

    public int getItemCount(){
        return itemsList.size();
    }

    class OpenListViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNo,textViewListName, textViewListQty;
        public OpenListViewHolder(View itemView){
            super(itemView);
            textViewNo = itemView.findViewById(R.id.item_nr);
            textViewListName = itemView.findViewById(R.id.tv_item_name);
            textViewListQty = itemView.findViewById(R.id.tv_item_quantity);
        }
    }
}
