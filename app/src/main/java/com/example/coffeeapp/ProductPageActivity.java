package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class ProductPageActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_product_page);

        Intent intent = getIntent();
        int id = intent.getIntExtra("prod_id", -1);

        Database db = new Database();
        try {
            if (id >= 0) {
                Coffee coffee = db.get_coffee(id);
                Log.i("COFFEE FOUND", coffee.getName());
            } else {
                Log.e("Id not found", Integer.toString(id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
