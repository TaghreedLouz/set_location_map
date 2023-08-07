package com.devtaghreed.map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.devtaghreed.map.databinding.ActivitySplashBinding;


public class Splash_Activity extends AppCompatActivity {
    ActivitySplashBinding binding;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        animation = AnimationUtils.loadAnimation(this,R.anim.splash);
        binding.imageView.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), com.devtaghreed.map.HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}