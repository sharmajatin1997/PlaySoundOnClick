package com.app.playsoundonclick;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    MediaPlayer mp;
    int[] music={R.raw.sample1, R.raw.sample2,
            R.raw.sample3};
    Random r = new Random();
    int Low = 0;
    int High = 3;
    int rndm = r.nextInt(High-Low) + Low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        mp = MediaPlayer.create(getApplicationContext(),music[rndm]);
        mp.setLooping(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        rndm = r.nextInt(High-Low) + Low;
                        mp = MediaPlayer.create(getApplicationContext(),music[rndm]);
                        mp.setLooping(true);
                    }
                    mp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}