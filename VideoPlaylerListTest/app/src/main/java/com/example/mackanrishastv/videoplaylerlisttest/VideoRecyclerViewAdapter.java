package com.example.mackanrishastv.videoplaylerlisttest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private Context context;
    private List<Video> videoList;

    public VideoRecyclerViewAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        final int positionPlayVideo = position;
        String capitalizedVideoName = capitalizeName(videoList.get(position).getName());
        holder.getTxtViewVideoName().setText(capitalizedVideoName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoScreenActivity.class);
                intent.putExtra("position", positionPlayVideo);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public void setVideoList(List<Video> videoList){
        this.videoList = videoList;
    }

    String capitalizeName (String name) {
        if (name.length() == 0) {
            return "";
        }
        if (name.length() == 1){
            return name.toUpperCase();
        }
        return name.substring(0,1).toUpperCase()
                + name.substring(1).toLowerCase();
    }


}
