package com.edgar.testdao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "MyUserDatabase";

    private static UserDatabase instance = null;
    private static final Object LOCK = new Object();

    public static UserDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

    public abstract UserDao userDao();
}
