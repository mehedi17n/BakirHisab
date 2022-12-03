package com.example.bakirhisab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 3000;
    Animation mainanim;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);

        //Animations
        mainanim = AnimationUtils.loadAnimation(this, R.anim.mainanim);

        image = findViewById(R.id.imgID);
        //Set animation to elements
        image.setAnimation(mainanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (SecondActivity.this, MainActivity.class) ;
                startActivity (intent) ;
                finish();
            }
        },SPLASH_SCREEN);
    }
}