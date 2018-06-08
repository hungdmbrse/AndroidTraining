package com.example.mackanrishastv.videoplaylerlisttest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoScreenActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private static final String GO_UP = "goup";
    private static final String GO_DOWN = "godown";

    private VideoView videoView;
    private MediaController mediaController;
    private List<Video> videoList;
    private Video linkVideo;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);

        setUpView();

        getVideoList();

        if(mediaController == null){
            mediaController = new MediaController(this);
            mediaController.setPrevNextListeners(onClickListenerNext, onClickListenerPrevious);
        }

        try {
            videoView.setMediaController(mediaController);
            position = getPosition();
            linkVideo = videoList.get(position);
            String path = "android.resource://" + getPackageName() + "/" + linkVideo.getLink();
            videoView.setVideoURI(Uri.parse(path));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

        videoView.start();
        videoView.setOnCompletionListener(this);
    }

    public void setUpView(){
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    public void getVideoList(){
        videoList = new ArrayList<>();
        videoList.add(new Video(getString(R.string.video1), R.raw.when_she_says_her_parents_arent_home));
        videoList.add(new Video(getString(R.string.video2), R.raw.wait_for_it));
        videoList.add(new Video(getString(R.string.video3), R.raw.trailer_footage_vs_actual_gameplay));
        videoList.add(new Video(getString(R.string.video4), R.raw.this_is_the_first_time_i_laughed_at_a_bull_fighting));
        videoList.add(new Video(getString(R.string.video5), R.raw.so_close));
        videoList.add(new Video(getString(R.string.video6), R.raw.she_did_it_im_the_good_boy_so_lets_play));
        videoList.add(new Video(getString(R.string.video7), R.raw.owner_dresses_up_as_dogs_favourite_toy));
        videoList.add(new Video(getString(R.string.video8), R.raw.master_of_comedy));
        videoList.add(new Video(getString(R.string.video9), R.raw.mans_best_friend));
        videoList.add(new Video(getString(R.string.video10), R.raw.hugh_jackman_runs_into_a_former_student));
        videoList.add(new Video(getString(R.string.video11), R.raw.he_came_to_work_without_his_laptop_but_he_will_not_let_anything_stand_between_him_and_productivity));
        videoList.add(new Video(getString(R.string.video12), R.raw.five_more_minutes_please));
    }

    public int getPosition(){
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        return position;
    }

    private View.OnClickListener onClickListenerNext = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            position += 1;
            nextVideoPlay(position, GO_DOWN);
        }
    };

    private View.OnClickListener onClickListenerPrevious = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            position -= 1;
            previousVideoPlay(position, GO_UP);
        }
    };

    @Override
    public void onCompletion(MediaPlayer mp) {
        position += 1;
        nextVideoPlay(position, GO_DOWN);
    }

    public void nextVideoPlay(int currentPosition, String action) {
        position = validatePosition(currentPosition, action);
        String path = "android.resource://" + getPackageName() + "/" + videoList.get(position).getLink();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

    public void previousVideoPlay(int currentPosition, String action){
        position = validatePosition(currentPosition, action);
        String path = "android.resource://" + getPackageName() + "/" + videoList.get(position).getLink();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

    public int validatePosition(int position, String action){
        int videoListSize = videoList.size();
        if(action.equals(GO_UP)){
            if(position < 0){
                position = (videoListSize-1);
                return position;
            }
        }
        if(action.equals(GO_DOWN)){
            if(position > (videoListSize-1)){
                position = 0;
                return position;
            }
        }
        return position;
    }
}
