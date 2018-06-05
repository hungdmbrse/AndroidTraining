package com.example.mackanrishastv.question43;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MusicListRecycleViewAdapter.MusicListListener,
        MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;
    private MusicListRecycleViewAdapter adapter;
    private List<Song> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MusicListRecycleViewAdapter();
        adapter.setListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.getItemAnimator().setChangeDuration(0);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        musicList = new ArrayList<>();
        musicList.add(new Song("Cham Day Noi Dau",R.raw.chamdaynoidauerik));
        musicList.add(new Song("Co Gai m52",R.raw.cogaim52huytung));
        musicList.add(new Song("Dung Ai Nhac Ve Anh Ay",R.raw.dungainhacveanhaytramy));
        musicList.add(new Song("Nhu Mot Thoi Quen",R.raw.nhumotthoiquenhakootadungha));
        musicList.add(new Song("Nu Hon Danh Roi",R.raw.nuhondanhroihoangyenchibi));
        adapter.setMusicList(musicList);
        adapter.notifyDataSetChanged();

        mediaPlayer = new MediaPlayer();


        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void play(int filePath) {
        Log.i("System.out", String.valueOf(filePath));

        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, filePath);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.start();

        reload();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
        mediaPlayer.reset();

        reload();
    }


    private void reload(){
        adapter.notifyItemRangeChanged(0,musicList.size());
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.i("System.out","finished");
        adapter.complete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
