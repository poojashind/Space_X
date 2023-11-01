package com.example.interviewproject.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interviewproject.R;
import com.example.interviewproject.model.SpaceXLaunchResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpaceXListAatapter extends RecyclerView.Adapter<SpaceXListAatapter.ViewHolder> {

    private List<SpaceXLaunchResponse> spaceXLaunchResponses;
    public SpaceXListAatapter(List<SpaceXLaunchResponse> spaceXLaunchResponses) {
        this.spaceXLaunchResponses = spaceXLaunchResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.space_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(spaceXLaunchResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return spaceXLaunchResponses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView missionNameTv, LaunchDateTv, rocketNameTV, launchStatus;
        private final ImageView missionImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            missionImage = itemView.findViewById(R.id.mission_image);
            missionNameTv = itemView.findViewById(R.id.mission_name);
            LaunchDateTv = itemView.findViewById(R.id.launch_date);
            rocketNameTV = itemView.findViewById(R.id.rocket_name);
            launchStatus = itemView.findViewById(R.id.launch_status);
        }

        void bind(SpaceXLaunchResponse spaceXLaunchResponse) {
            missionNameTv.setText(spaceXLaunchResponse.getMissionName());
            LaunchDateTv.setText(spaceXLaunchResponse.getLaunchDateLocal());
            rocketNameTV.setText(spaceXLaunchResponse.getRocket().getRocketName());
            launchStatus.setText(spaceXLaunchResponse.getLaunchSuccess().toString());
            Picasso.get()
                    .load(spaceXLaunchResponse.getLinks().getMissionPatchSmall())
                    .into(missionImage);


        }
    }
}
