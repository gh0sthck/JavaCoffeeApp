package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_welcome);

        Button login_button = findViewById(R.id.aWelLoginButton);
        Button register_button = findViewById(R.id.aWelRegButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(login_intent);
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(register_intent);
            }
        });
    }
}
