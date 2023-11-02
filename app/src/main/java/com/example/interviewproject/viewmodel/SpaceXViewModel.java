package com.example.interviewproject.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.interviewproject.Repository.SpaceRepository;
import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.List;

public class SpaceXViewModel extends ViewModel {

    private SpaceRepository repository;
    public void init(Application application) {
        repository = new SpaceRepository(application);
    }

    public void getSpaceXData(boolean isFromPullToRefresh) {
        repository.getSpaceXDataAndStoreToDB(isFromPullToRefresh);
    }

    public LiveData<List<SpaceXLaunchResponse>> getSpaceXMutableLiveData() {
        return repository.getAllSpaceXData();
    }

    public void updateBookMarkField(boolean isBookMark, int id) {
        repository.updateBookMarkField(isBookMark, id);
    }
}

