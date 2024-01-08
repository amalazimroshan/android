package com.example.courseoutcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }

    @Override
    protected void onPause() {
            super.onPause();
            SharedPreferences sharedPreferences = getSharedPreferences("Store",MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("username",username.getText().toString());
            edit.putString("password",password.getText().toString());
            edit.apply();
            edit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Store",MODE_PRIVATE);
        username.setText(sharedPreferences.getString("username","") + ":");
        password.setText(sharedPreferences.getString("password","") + ":");

    }
}