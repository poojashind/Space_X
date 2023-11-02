package com.example.interviewproject.Repository;

import android.app.Application;
import android.util.Log;

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
    private LiveData<List<SpaceXLaunchResponse>> allSpaceXLaunches = new MutableLiveData<>();

    public SpaceRepository(Application application) {
        RoomDataBaseBuilder database = RoomDataBaseBuilder.getInstance(application);
        spaceXDao = database.SpaceXDao();
    }

    public void getSpaceXDataAndStoreToDB(boolean isFromPullToRefresh) {
        if(isFromPullToRefresh || checkDbCount() <= 0) {
            Log.d("TAG", "getSpaceXDataAndStoreToDB: " + "if part");

            APIInterface apiInterface = RetrofitBuilder.getInstance().create(APIInterface.class);
            MutableLiveData<List<SpaceXLaunchResponse>> spaceResponse = new MutableLiveData<>();
            apiInterface.getSpaceLaunchData().enqueue(new Callback<ArrayList<SpaceXLaunchResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<SpaceXLaunchResponse>> call, Response<ArrayList<SpaceXLaunchResponse>> response) {
                    RoomDataBaseBuilder.databaseWriteExecutor.execute(() -> spaceXDao.insert(response.body()));
                }

                @Override
                public void onFailure(Call<ArrayList<SpaceXLaunchResponse>> call, Throwable t) {
                    spaceResponse.postValue(null);
                }
            });
        }
    }

    private int checkDbCount() {
        AtomicInteger count = new AtomicInteger();
        RoomDataBaseBuilder.databaseWriteExecutor.execute(() -> count.set(spaceXDao.getDataCount()));
        Log.d(SpaceRepository.class.getName(), count.get() + "");
        return count.get();
    }
    public LiveData<List<SpaceXLaunchResponse>> getAllSpaceXData() {
        return spaceXDao.getAllSpacexLaunches();
    }

    public void updateBookMarkField(boolean isBookMark, int id) {
        RoomDataBaseBuilder.databaseWriteExecutor.execute(() -> spaceXDao.update(isBookMark, id));
    }
}
