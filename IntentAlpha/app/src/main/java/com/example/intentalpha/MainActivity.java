package com.example.intentalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username.getText().toString());
                    bundle.putString("password", password.getText().toString());

                    Intent intent = new Intent(MainActivity.this, Home.class).putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}