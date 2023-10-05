package com.shanidev.blissDB;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.shanidev.zesapp.R;

public class DashBoard extends AppCompatActivity {

    BottomNavigationView nBottomNavigationView;
    FrameLayout nFramelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        nBottomNavigationView = findViewById(R.id.bottomNavigationView);
        nFramelayout = findViewById(R.id.frameLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();

        nBottomNavigationView.setSelectedItemId(R.id.home);

        nBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.messages:
                        fragment = new MessagesFragment();
                        break;
                    case R.id.post:
                        fragment = new PostFragment();
                        break;
                    case R.id.search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.account:
                        fragment = new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
                return true;
            }
        });



    }
}