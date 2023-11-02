package com.example.interviewproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interviewproject.R;
import com.example.interviewproject.model.SpaceXLaunchResponse;
import com.example.interviewproject.util.DateTimeConverter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class LaunchDetailsActivity extends AppCompatActivity {

    private ImageView missionPatchImageView;
    private TextView missionNameTextView;
    private TextView launchDateTextView;
    private TextView launchDateTimeTextView;
    private TextView missionDescriptionTextView;
    private TextView missionDescriptionDetailsTextView;
    private TextView rocketDetailsTextView;
    private TextView rocketNameTextView;
    private TextView rocketTypeTextView;
    private TextView rocketDescriptionTextView;
    private TextView launchDetailsTextView;
    private TextView launchStatusTextView;
    private TextView launchSiteTextView;
    private TextView launchWindowTextView;
    private TextView missionPatchTextView;
    private ImageView missionPatchImage;
    private TextView linkTextView;
    private TextView articleLinkTextView;
    private TextView presskitLinkTextView;
    private TextView wikipediaLinkTextView;
    private SpaceXLaunchResponse spaceXLaunchResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details_screen);
        getIntentData();
        initializeView();
        setData();
    }

    private void getIntentData() {
        Gson gson = new Gson();
        String spaceXLaunchResponsesString = getIntent().getStringExtra("SpaceXLaunchResponses");
        spaceXLaunchResponse = gson.fromJson(spaceXLaunchResponsesString, SpaceXLaunchResponse.class);
    }

    private void initializeView() {
        missionPatchImageView = findViewById(R.id.mission_patch_iv);
        missionNameTextView = findViewById(R.id.mission_name_tv);
        launchDateTextView = findViewById(R.id.launch_date_tv);
        launchDateTimeTextView = findViewById(R.id.launch_date_time_tv);
        missionDescriptionTextView = findViewById(R.id.missionDescriptionTextView);
        missionDescriptionDetailsTextView = findViewById(R.id.mission_description_details_tv);
        rocketDetailsTextView = findViewById(R.id.rocket_details_tv);
        rocketNameTextView = findViewById(R.id.rocket_name_tv);
        rocketTypeTextView = findViewById(R.id.rocket_type_tv);
        rocketDescriptionTextView = findViewById(R.id.rocket_escription_tv);
        launchDetailsTextView = findViewById(R.id.launch_details_tv);
        launchStatusTextView = findViewById(R.id.launch_status_tv);
        launchSiteTextView = findViewById(R.id.launch_site_tv);
        launchWindowTextView = findViewById(R.id.launch_window_tv);
        missionPatchTextView = findViewById(R.id.mission_patch_tv);
        missionPatchImage = findViewById(R.id.mission_patch_detals_iv);
        linkTextView = findViewById(R.id.link_tv);
        articleLinkTextView = findViewById(R.id.article_link_tv);
        presskitLinkTextView = findViewById(R.id.presskit_link_tv);
        wikipediaLinkTextView = findViewById(R.id.wikipedia_link_tv);
    }

    private void setData() {
        String payloadId = "", payloadType = "", manufacturer = "", payloadMassKgs = "", orbit = "", launchStatus;
        Picasso.get()
                .load(spaceXLaunchResponse.getLinks().getMissionPatchSmall())
                .into(missionPatchImageView);
        missionNameTextView.setText(spaceXLaunchResponse.getMissionName());
        launchDateTimeTextView.setText(DateTimeConverter.getFormattedDateTime(spaceXLaunchResponse.getLaunchDateLocal()));
        missionDescriptionDetailsTextView.setText(spaceXLaunchResponse.getDetails());
        if (spaceXLaunchResponse.getRocket().getRocketName() != null)
            rocketNameTextView.setText(String.format("Rocket Name:%s", spaceXLaunchResponse.getRocket().getRocketName()));
        else
            rocketNameTextView.setVisibility(View.GONE);
        if (spaceXLaunchResponse.getRocket().getRocketType() != null)
            rocketTypeTextView.setText(String.format("Rocket Type:%s", spaceXLaunchResponse.getRocket().getRocketType()));
        else
            rocketNameTextView.setVisibility(View.GONE);

        if (spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadId() != null)
            payloadId = "Payload Id: " + spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadId();
        if (spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadType() != null)
            payloadType = "Payload Type: " + spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadType();
        if (spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getManufacturer() != null)
            manufacturer = "Manufacturer: " + spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getManufacturer();
        if (spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadMassKg() != null)
            payloadMassKgs = "Payload Mass in Kgs: " + spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getPayloadMassKg().toString();
        if (spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getOrbit() != null)
            orbit = "Orbit: " + spaceXLaunchResponse.getRocket().getSecondStage().getPayloads().get(0).getOrbit();
        rocketDescriptionTextView.setText(String.format("Rocket Description: %s\n%s\n%s\n%s\n%s", payloadId, payloadType, manufacturer, payloadMassKgs, orbit));

        if (spaceXLaunchResponse.getUpcoming()) {
            launchStatus = "Upcoming";
        } else if (spaceXLaunchResponse.getLaunchSuccess()) {
            launchStatus = "Successful";
        } else {
            launchStatus = "Failed \n Reason: " + spaceXLaunchResponse.getLaunchFailureDetails().getReason();
        }
        launchStatusTextView.setText(String.format(launchStatus));

        if (spaceXLaunchResponse.getLaunchSite().getSiteNameLong() != null)
            launchSiteTextView.setText(String.format("Site Name: %s", spaceXLaunchResponse.getLaunchSite().getSiteNameLong()));
        else
            launchSiteTextView.setVisibility(View.GONE);

        launchWindowTextView.setText(String.format("Launch Window: %d", spaceXLaunchResponse.getLaunchWindow()));
        Picasso.get().load(spaceXLaunchResponse.getLinks().getMissionPatch()).into(missionPatchImage);

        if (spaceXLaunchResponse.getLinks().getArticleLink() != null)
            articleLinkTextView.setText(String.format("Article Link:%s", spaceXLaunchResponse.getLinks().getArticleLink()));
        else
            articleLinkTextView.setVisibility(View.GONE);

        if (spaceXLaunchResponse.getLinks().getPresskit() != null)
            presskitLinkTextView.setText(String.format("Press Kit Link:%s", spaceXLaunchResponse.getLinks().getPresskit()));
        else
            presskitLinkTextView.setVisibility(View.GONE);
        if (spaceXLaunchResponse.getLinks().getWikipedia() != null)
            wikipediaLinkTextView.setText(String.format("Wikipedia Link:%s", spaceXLaunchResponse.getLinks().getWikipedia()));
        else
            wikipediaLinkTextView.setVisibility(View.GONE);
    }
}