package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d("MainActivity", "test");
            return insets;
        });

        Button button = (Button) findViewById(R.id.login_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                onLogin(v);
            }
        });

        Button forgotPasswordButton = (Button) findViewById(R.id.forgot_password_btn);
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onForgotPassword(v);
            }
        });
    }

    public void onForgotPassword(View view) {
        Uri uri = Uri.parse("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onLogin(View view) {
        Log.d("MainActivity", "test");
        TextView usernameTextView = (TextView) findViewById(R.id.username_input);
        TextView passwordTextView = (TextView) findViewById(R.id.password_input);

        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        Log.d("MainActivity", "username: " + username);
        Log.d("MainActivity", "password: " + password);

        if (username.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            return;
        }


    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "test");
        TextView usernameTextView = (TextView) findViewById(R.id.username_input);
        TextView passwordTextView = (TextView) findViewById(R.id.password_input);
        usernameTextView.setText("");
        passwordTextView.setText("");
    }
}