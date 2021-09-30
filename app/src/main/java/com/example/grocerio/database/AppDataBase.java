package com.example.grocerio.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Items.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ItemsDao itemsDao();
}
