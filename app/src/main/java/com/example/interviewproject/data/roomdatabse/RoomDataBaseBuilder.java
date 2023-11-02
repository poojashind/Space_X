package com.example.interviewproject.data.roomdatabse;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {SpaceXLaunchResponse.class}, version = 2)
@TypeConverters({SpaceConverter.class})
public abstract class RoomDataBaseBuilder extends RoomDatabase {

    private static RoomDataBaseBuilder roomDataBaseBuilder;

    public abstract SpaceXDao SpaceXDao();

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized RoomDataBaseBuilder getInstance(Context context) {
        if (roomDataBaseBuilder == null) {
            roomDataBaseBuilder = Room.databaseBuilder(context.getApplicationContext(), RoomDataBaseBuilder.class, "space_launch_database")
                    .addTypeConverter(new SpaceConverter())
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return roomDataBaseBuilder;
    }
}
