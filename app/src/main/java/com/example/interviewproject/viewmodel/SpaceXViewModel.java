package com.example.interviewproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interviewproject.Repository.SpaceRepository;
import com.example.interviewproject.model.SpaceXLaunchResponse;

import java.util.List;

public class SpaceXViewModel extends ViewModel {

    private SpaceRepository repository;
    private MutableLiveData<List<SpaceXLaunchResponse>> spaceXMutableLiveData = new MutableLiveData<>();
    public SpaceXViewModel() {
        repository = new SpaceRepository();
    }

    public void getSpaceXData() {
        spaceXMutableLiveData = repository.getSpaceXData();
    }

    public MutableLiveData<List<SpaceXLaunchResponse>> getSpaceXMutableLiveData() {
        return spaceXMutableLiveData;
    }
}

