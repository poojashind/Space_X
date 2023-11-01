package com.example.interviewproject.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.interviewproject.data.api.APIInterface;
import com.example.interviewproject.data.api.RetrofitBuilder;
import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpaceRepository {

    public MutableLiveData<List<SpaceXLaunchResponse>> getSpaceXData() {
        APIInterface apiInterface = RetrofitBuilder.getInstance().create(APIInterface.class);
        MutableLiveData<List<SpaceXLaunchResponse>> spaceResponse = new MutableLiveData<>();
        apiInterface.getSpaceLaunchData().enqueue(new Callback<ArrayList<SpaceXLaunchResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<SpaceXLaunchResponse>> call, Response<ArrayList<SpaceXLaunchResponse>> response) {
                Log.d("Sucess", response.body().size() + "");
                spaceResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<SpaceXLaunchResponse>> call, Throwable t) {
                Log.d("failure", "failure" + 0 + t.getMessage());
                spaceResponse.postValue(null);
            }
        });
        return spaceResponse;
    }
}
