package com.example.interviewproject.data.roomdatabse;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.List;

@Dao
public interface SpaceXDao {

    @Query("SELECT * FROM space_launch_table")
    LiveData<List<SpaceXLaunchResponse>> getAllSpacexLaunches();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<SpaceXLaunchResponse> actorList);

    @Query("UPDATE space_launch_table SET is_bookmarked = :isBookMarked WHERE flight_number =:id")
    void update(boolean isBookMarked, int id);

    @Query("SELECT COUNT(flight_number) FROM space_launch_table")
    LiveData<Integer> getDataCount();
}
