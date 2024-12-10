package com.example.coffeeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button enter_button = findViewById(R.id.aRegButtonEnter);

        Database db = new Database();

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText phone_number = findViewById(R.id.aRegPhone);
                EditText name = findViewById(R.id.aRegName);

                if (phone_number != null && name != null) {
                    String phone = phone_number.getText().toString();
                    String username = name.getText().toString();
                    try {
                        db.add_user(
                                new User(-1, username, phone)
                        );
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        db.close_connection();
                    }

                    // to login
//                     Intent toLoginIntent = new Intent(RegisterActivity.this, ...)

                } else {
                    Log.e("No data required", "please, attempt again");
                }
            }
        });
    }
}
