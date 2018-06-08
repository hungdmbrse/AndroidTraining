package com.example.mackanrishastv.videoplaylerlisttest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VideoViewHolder extends RecyclerView.ViewHolder{

    private TextView txtViewVideoName;

    public VideoViewHolder(View itemView) {
        super(itemView);
        txtViewVideoName = (TextView) itemView.findViewById(R.id.txtView_VideoName);
    }

    public TextView getTxtViewVideoName() {
        return this.txtViewVideoName;
    }
}
