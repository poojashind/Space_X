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
import com.example.interviewproject.util.DateTimeConverter;
import com.example.interviewproject.view.SpaceCallback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpaceXListAatapter extends RecyclerView.Adapter<SpaceXListAatapter.ViewHolder> {

    private final List<SpaceXLaunchResponse> spaceXLaunchResponses;
    private final SpaceCallback callback;
    public SpaceXListAatapter(SpaceCallback callback, List<SpaceXLaunchResponse> spaceXLaunchResponses) {
        this.spaceXLaunchResponses = spaceXLaunchResponses;
        this.callback = callback;
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
        holder.itemView.setOnClickListener(v -> callback.loadDetailsPage(spaceXLaunchResponses.get(position)));
        holder.bookMarkIamgeView.setOnClickListener(v -> {
            callback.update(!spaceXLaunchResponses.get(position).isBookMarked(), spaceXLaunchResponses.get(position).getFlightNumber());
            if(!spaceXLaunchResponses.get(position).isBookMarked()) {
                holder.bookMarkIamgeView.setImageResource(R.drawable.ic_bookmark);
            } else {
                holder.bookMarkIamgeView.setImageResource(R.drawable.ic_bookmark_added);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spaceXLaunchResponses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView missionNameTv, LaunchDateTv, rocketNameTV, launchStatusTV;
        private final ImageView launchImageView, bookMarkIamgeView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            launchImageView = itemView.findViewById(R.id.launch_image_view);
            missionNameTv = itemView.findViewById(R.id.mission_name_tv);
            LaunchDateTv = itemView.findViewById(R.id.launch_date_tv);
            rocketNameTV = itemView.findViewById(R.id.rocket_name_tv);
            launchStatusTV = itemView.findViewById(R.id.launch_status_tv);
            bookMarkIamgeView = itemView.findViewById(R.id.bookmark_iv);
        }

        void bind(SpaceXLaunchResponse spaceXLaunchResponse) {
            String launchStatus;
            missionNameTv.setText(String.format("Mission Name: %s", spaceXLaunchResponse.getMissionName()));
            LaunchDateTv.setText(String.format("When %s", DateTimeConverter.getFormattedDateTime(spaceXLaunchResponse.getLaunchDateLocal())));
            rocketNameTV.setText(String.format("Rocket Name %s", spaceXLaunchResponse.getRocket().getRocketName()));
            if(spaceXLaunchResponse.getUpcoming()) {
                launchStatus = "Upcoming";
            } else if(spaceXLaunchResponse.getLaunchSuccess()) {
                launchStatus = "Successful";
            } else {
                launchStatus = "Failed";
            }
            launchStatusTV.setText(String.format("Status %s", launchStatus));
            Picasso.get()
                    .load(spaceXLaunchResponse.getLinks().getMissionPatchSmall())
                    .into(launchImageView);
            if(spaceXLaunchResponse.isBookMarked()) {
                bookMarkIamgeView.setImageResource(R.drawable.ic_bookmark_added);
            } else {
                bookMarkIamgeView.setImageResource(R.drawable.ic_bookmark);
            }
        }
    }
}
