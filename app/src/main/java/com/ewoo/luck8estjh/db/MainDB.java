package com.ewoo.luck8estjh.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ewoo.luck8estjh.model.Exercise;
import com.ewoo.luck8estjh.model.ExerciseDao;
import com.ewoo.luck8estjh.model.Gym;
import com.ewoo.luck8estjh.model.GymDao;

@Database(entities = {Exercise.class, Gym.class}, version = 1)
public abstract class MainDB extends RoomDatabase {
    public abstract ExerciseDao exerciseDao();
    public abstract GymDao gymDao();

    private static MainDB instance;

    private static final Object sLock = new Object();

    public static MainDB getInstance(Context context) {
        synchronized (sLock) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MainDB.class, "mainDB")
                        .allowMainThreadQueries()
                        .build();
            }
            return instance;
        }
    }
}
