package com.example.grocerio;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    public ArrayList<String> ItemNameList;
    public ArrayList<String> ItemQtyList;

    private final ArrayList<String> itemNameListTemp;
    private final ArrayList<String> itemQtyListTemp;

    private final int namevalue = 2000300;
    private final int qtyvalue = 2000400;

    public ItemsAdapter(ArrayList<String> itemN, ArrayList<String> itemQ) {

        int size = itemN.size();
        ItemNameList = itemN;
        ItemQtyList = itemQ;

        for(;size<60;size++){ //hardcoding 60 items per list
            ItemNameList.add(size,"");
            ItemQtyList.add(size,"");
        }
        itemNameListTemp = ItemNameList;
        itemQtyListTemp = ItemQtyList;
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemsView = inflater.inflate(R.layout.item_list_populate,parent,false);

        return new ViewHolder(itemsView);
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position){

        String number = Integer.toString(position+1);
        TextView itemNr = holder.itemNumber;
        itemNr.setText(number + ".");

        EditText editItem = holder.itemNameET;
        editItem.setText(ItemNameList.get(position));
        editItem.setId(namevalue+position);

        EditText editQty = holder.itemQtyET;
        editQty.setText(ItemQtyList.get(position));
        editQty.setId(qtyvalue+position);

    }

    @Override
    public int getItemCount(){
        return ItemNameList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView itemNumber;
        public EditText itemNameET;
        public EditText itemQtyET;

        public ViewHolder(View itemView){
            super(itemView);

            itemNumber = itemView.findViewById(R.id.item_nr);
            itemNameET = itemView.findViewById(R.id.item_name);
            itemQtyET = itemView.findViewById(R.id.item_quantity);

            itemNameET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    ItemNameList.set(getAdapterPosition(),s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    String string = s.toString();
                    itemNameListTemp.set(getAdapterPosition(),string);
                }
            });

            itemQtyET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    ItemQtyList.set(getAdapterPosition(),s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    String string = s.toString();
                    itemQtyListTemp.set(getAdapterPosition(),string);
                }
            });

        }
    }

    public ArrayList<String> getItemNameListTemp(){
        return itemNameListTemp;
    }
    public ArrayList<String> getItemQtyListTemp(){
        return itemQtyListTemp;
    }

}
