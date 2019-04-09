package com.tuannv.base.baseprojectandroid.data.local.dao;

import android.content.Context;

import com.tuannv.base.baseprojectandroid.data.model.Example;
import com.tuannv.base.baseprojectandroid.data.model.Example2;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Example.class, Example2.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract ExampleDao exampleDao();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                Room.databaseBuilder(context, AppDatabase.class, "ExampleDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}