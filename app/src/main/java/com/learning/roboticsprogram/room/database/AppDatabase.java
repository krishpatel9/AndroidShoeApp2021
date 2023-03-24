package com.learning.roboticsprogram.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learning.roboticsprogram.room.dao.AppDao;
import com.learning.roboticsprogram.room.entity.Shoe;

@Database(entities = Shoe.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static synchronized AppDatabase getDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "shoe_db"
            ).build();
        }
        return appDatabase;
    }

    public abstract AppDao appDao();
}
