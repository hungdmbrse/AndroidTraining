package com.example.mackanrishastv.videoplaylerlisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private List<Video> videoList;
    private RecyclerView videoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        setUpView();

        VideoRecyclerViewAdapter videoRecyclerViewAdapter = new VideoRecyclerViewAdapter(this);
        videoRecyclerViewAdapter.setVideoList(videoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        videoRecyclerView.setHasFixedSize(true);
        videoRecyclerView.setLayoutManager(linearLayoutManager);
        videoRecyclerView.setAdapter(videoRecyclerViewAdapter);

    }

    public void setUpView(){
        videoRecyclerView = (RecyclerView) findViewById(R.id.videoRecyclerView);
    }

}
