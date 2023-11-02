package com.example.interviewproject.Repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.interviewproject.data.api.APIInterface;
import com.example.interviewproject.data.api.RetrofitBuilder;
import com.example.interviewproject.data.roomdatabse.RoomDataBaseBuilder;
import com.example.interviewproject.data.roomdatabse.SpaceXDao;
import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpaceRepository {

    private final SpaceXDao spaceXDao;

    public SpaceRepository(Application application) {
        RoomDataBaseBuilder database = RoomDataBaseBuilder.getInstance(application);
        spaceXDao = database.SpaceXDao();
    }

    public void getSpaceXDataAndStoreToDB() {
            APIInterface apiInterface = RetrofitBuilder.getInstance().create(APIInterface.class);
            MutableLiveData<List<SpaceXLaunchResponse>> spaceResponse = new MutableLiveData<>();
            apiInterface.getSpaceLaunchData().enqueue(new Callback<ArrayList<SpaceXLaunchResponse>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<SpaceXLaunchResponse>> call, @NonNull Response<ArrayList<SpaceXLaunchResponse>> response) {
                    RoomDataBaseBuilder.databaseWriteExecutor.execute(() -> spaceXDao.insert(response.body()));
                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<SpaceXLaunchResponse>> call, @NonNull Throwable t) {
                    spaceResponse.postValue(null);
                }
            });
    }

    public LiveData<Integer> checkDbCount() {
        return spaceXDao.getDataCount();
    }
    public LiveData<List<SpaceXLaunchResponse>> getAllSpaceXData() {
        return spaceXDao.getAllSpacexLaunches();
    }

    public void updateBookMarkField(boolean isBookMark, int id) {
        RoomDataBaseBuilder.databaseWriteExecutor.execute(() -> spaceXDao.update(isBookMark, id));
    }
}
