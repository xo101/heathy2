package com.gczy.p02_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity
{
    private Handler handler=new Handler();
    private  Runnable runnableToMainActivity=new Runnable() {
        @Override
        public void run() {
            toMainACtivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowsFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(runnableToMainActivity, 3000);

       // setContentView(R.layout.activity_splash);
    }
    private  void toMainACtivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        handler.removeCallbacks(runnableToMainActivity);
    }
}