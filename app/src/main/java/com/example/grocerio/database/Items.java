package com.example.grocerio.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Items implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "ListNo")
    private Integer ListNo;

    @ColumnInfo(name = "ItemName")
    private String ItemName;

    @ColumnInfo(name = "ItemQty")
    private String ItemQty;

    @ColumnInfo(name = "Date")
    private String Date;


    public int getId(){
        return id;
    }

    public Integer getListNo(){
        return ListNo;
    }

    public String getItemName(){
        return ItemName;
    }
    public String getItemQty(){
        return ItemQty;
    }

    public String getDate(){
        return Date;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setListNo(Integer ListNo){
        this.ListNo = ListNo;
    }

    public void setItemName(String ItemName){
        this.ItemName = ItemName;
    }

    public void setItemQty(String ItemQty){
        this.ItemQty = ItemQty;
    }

    public void setDate(String Date){
        this.Date = Date;
    }
}
