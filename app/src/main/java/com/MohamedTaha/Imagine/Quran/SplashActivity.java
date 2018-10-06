package com.MohamedTaha.Imagine.Quran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    //variable for store WAIT_TIME ==2500
    private static final int WAIT_TIME = 2500;
    //define TextView
    TextView textShow;
    //variable for timer
    private Timer waitTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //callback methos defineVariables()
        defineVariables();
        //for wait The Activity for 2500 seconds then start new Activity GridViewActivity

        waitTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                startSplashActivity();

            }
        },WAIT_TIME);
       /* waitTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                SplashActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startSplashActivity();
                    }
                });
            }
        }, WAIT_TIME);*/
    }

    //method for start Activity after 2500 seconds
    private void startSplashActivity() {
        startActivity(new Intent(this, GridViewActivity.class));
        finish();
    }

    //method for define All variables
    private void defineVariables() {
        textShow = (TextView) findViewById(R.id.tv_show_text);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.aminmation_splash);
        textShow.startAnimation(animation);

        waitTimer = new Timer();
    }

    @Override
    public void onBackPressed() {
        //for disable button back
    }
}

























