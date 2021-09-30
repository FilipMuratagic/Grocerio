package com.example.grocerio.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemsDao {

    @Query("SELECT * FROM Items")
    List<Items> getAll();

    @Query("SELECT * FROM Items WHERE ListNo=:ListNumber")
    List<Items> getAllItems(int ListNumber);

    @Query("SELECT * FROM Items WHERE ListNo>:ListNumber")
    List<Items> getItemsToUpdate(int ListNumber);

    @Query("SELECT COUNT(ListNo) FROM Items WHERE ListNo=:ListNumber")
    int getItemsAmount(int ListNumber);

    @Query("SELECT MAX(ListNo) FROM Items")
    int getMaxListNo();

    @Query("SELECT DISTINCT ListNo FROM Items ORDER BY ListNo ASC")
    int[] getListAmount();

    @Query("SELECT id,ListNo,Date FROM Items WHERE ListNo IN (SELECT DISTINCT ListNo) GROUP BY ListNo")
    List<Items> getDateList();

    @Insert
    void insert(Items items);

    @Delete
    void delete(Items items);

    @Query("DELETE FROM Items")
    void deleteAll();

    @Update
    void update(Items items);

}
