package com.example.interviewproject.view.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.interviewproject.R;
import com.example.interviewproject.model.SpaceXLaunchResponse;
import com.example.interviewproject.view.adapter.SpaceXListAatapter;
import com.example.interviewproject.viewmodel.SpaceXViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SpaceXViewModel spaceXViewModel;
    private RecyclerView spaceListRv;
    private SpaceXListAatapter spaceXListAatapter;
    private ProgressBar loaderPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeViewModel();
        observeData();
    }

    private void initializeViewModel() {
        spaceXViewModel = new ViewModelProvider(this).get(SpaceXViewModel.class);
        spaceXViewModel.init(this.getApplication());
    }

    private void initializeViews() {
        spaceListRv = findViewById(R.id.space_list_rv);
        spaceListRv.setLayoutManager(new LinearLayoutManager(this));
        loaderPB = findViewById(R.id.loader_pb);
    }

    private void observeData() {
        loaderPB.setVisibility(View.VISIBLE);
        spaceXViewModel.getSpaceXData();
        spaceXViewModel.getSpaceXMutableLiveData().observe(this, spaceXLaunchResponses -> {
            if(!spaceXLaunchResponses.isEmpty()) {
                loaderPB.setVisibility(View.GONE);
                spaceXListAatapter = new SpaceXListAatapter(this, spaceXLaunchResponses);
                spaceListRv.setAdapter(spaceXListAatapter);
            }
        });
    }
}