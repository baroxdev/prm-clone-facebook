package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getIntent() != null) {
            String username = getIntent().getStringExtra("username");
            TextView welcomeTextView = findViewById(R.id.welcome_text);
            welcomeTextView.setText("Welcome, " + username + "!");
        }

        Button logoutButton = (Button) findViewById(R.id.logout_btn);
        logoutButton.setOnClickListener(v -> {
            // Handle logout button click
            // For example, navigate to the login screen
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        Button quitButton = (Button) findViewById(R.id.quit_btn);
        quitButton.setOnClickListener(v -> {
            // Handle quit button click
            // finish app
            finish();
        });
    }

    @Override
    protected  void onRestart() {
        super.onRestart();
        Log.d("HomeActivity", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HomeActivity", "onStop");
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Log.d("HomeActivity", "onPause");
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Log.d("HomeActivity", "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HomeActivity", "onResume");
    }
}