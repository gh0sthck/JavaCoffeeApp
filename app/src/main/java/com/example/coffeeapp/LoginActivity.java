package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_login);

        Button enter_button = findViewById(R.id.aLoginEnter);
        Database db = new Database();

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number = findViewById(R.id.aLoginNumber);

                if (number != null) {
                    try {
                        User result = db.get_user(number.getText().toString());
                        Log.i("Result", result.toString());
                        if (result != null) {  // Temporary decision while verification not ready
                            Intent main_intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(main_intent);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        db.close_connection();
                    }
                }
            }
        });
    }
}
