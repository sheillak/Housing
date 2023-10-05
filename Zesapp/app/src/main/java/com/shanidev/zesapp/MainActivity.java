package com.shanidev.zesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shanidev.blissDB.DashBoard;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        //Handler
        int SPLASH_SCREEN = 3000;
        new Handler().postDelayed(() -> {

            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null) {
                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent);
                finish();

            }}, SPLASH_SCREEN);
    }
}