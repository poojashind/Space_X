package com.example.interviewproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.interviewproject.R;
import com.example.interviewproject.model.SpaceXLaunchResponse;
import com.example.interviewproject.view.adapter.SpaceXListAatapter;
import com.example.interviewproject.viewmodel.SpaceXViewModel;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements SpaceCallback {

    private SpaceXViewModel spaceXViewModel;
    private RecyclerView spaceListRv;
    private SpaceXListAatapter spaceXListAatapter;
    private ProgressBar loaderPB;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        manageSwipeRefreshLayout();
        initializeViewModel();
        observeData(false);
    }

    private void initializeViewModel() {
        spaceXViewModel = new ViewModelProvider(this).get(SpaceXViewModel.class);
        spaceXViewModel.init(this.getApplication());
    }

    private void manageSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            observeData(true);
        });
    }
    private void initializeViews() {
        spaceListRv = findViewById(R.id.space_list_rv);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        spaceListRv.setLayoutManager(new LinearLayoutManager(this));
        loaderPB = findViewById(R.id.loader_pb);
    }

    private void observeData(boolean isFromPullToRefresh) {
        loaderPB.setVisibility(View.VISIBLE);
        spaceXViewModel.getSpaceXData(isFromPullToRefresh);
        spaceXViewModel.getSpaceXMutableLiveData().observe(this, spaceXLaunchResponses -> {
                loaderPB.setVisibility(View.GONE);
                spaceXListAatapter = new SpaceXListAatapter(this, spaceXLaunchResponses);
                spaceListRv.setAdapter(spaceXListAatapter);
        });
    }

    @Override
    public void update(boolean isBookMark, int id) {
        spaceXViewModel.updateBookMarkField(isBookMark, id);
    }

    @Override
    public void loadDetailsPage(SpaceXLaunchResponse response) {
        Intent intent = new Intent(this, LaunchDetailsActivity.class);
        Gson gson = new Gson();
        intent.putExtra("SpaceXLaunchResponses", gson.toJson(response));
        startActivity(intent);
    }
}