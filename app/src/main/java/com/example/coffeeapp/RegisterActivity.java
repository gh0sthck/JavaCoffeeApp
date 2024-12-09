package com.example.coffeeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button enter_button = findViewById(R.id.aRegButtonEnter);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText phone_number = findViewById(R.id.aRegPhone);
                EditText name = findViewById(R.id.aRegName);

                if (phone_number != null && name != null) {
                    Log.i("PHONE", phone_number.getText().toString());
                    Log.i("NAME", name.getText().toString());
                } else {
                    Log.e("No data required", "please, attempt again");
                }
            }
        });
    }
}
