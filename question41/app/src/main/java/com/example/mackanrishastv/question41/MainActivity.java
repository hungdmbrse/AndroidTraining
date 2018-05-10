package com.example.mackanrishastv.question41;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

    ImageView imageView;
    SeekBar redBar, greenBar, blueBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.iv);
        redBar = (SeekBar)findViewById(R.id.redbar);
        greenBar = (SeekBar)findViewById(R.id.greenbar);
        blueBar = (SeekBar)findViewById(R.id.bluebar);

        redBar.setOnSeekBarChangeListener(colorBarChangeListener);
        greenBar.setOnSeekBarChangeListener(colorBarChangeListener);
        blueBar.setOnSeekBarChangeListener(colorBarChangeListener);

        setColorFilter(imageView);
    }

    OnSeekBarChangeListener colorBarChangeListener
            = new OnSeekBarChangeListener(){

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            setColorFilter(imageView);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }};

    private void setColorFilter(ImageView iv){

        float redValue = ((float)redBar.getProgress())/255;
        float greenValue = ((float)greenBar.getProgress())/255;
        float blueValue = ((float)blueBar.getProgress())/255;

        float[] colorMatrix = {
                redValue, 0, 0, 0, 0,  //red
                0, greenValue, 0, 0, 0, //green
                0, 0, blueValue, 0, 0,  //blue
                0, 0, 0, 1, 0    //alpha
        };

        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);

        iv.setColorFilter(colorFilter);

    }


}