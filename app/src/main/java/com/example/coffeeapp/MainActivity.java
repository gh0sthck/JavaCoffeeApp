package com.example.coffeeapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database db = new Database();

        List<Coffee> coffies = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try {
            coffies = db.get_coffies();
            if (coffies != null) {
                for (int i = 0; i < coffies.size(); i++) {
                    Log.i("Coffee", coffies.get(i).getName());
                    ids.add(coffies.get(i).getId());
                    titles.add(coffies.get(i).getName());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ArrayList images = new ArrayList<>(List.of(R.drawable.button, R.drawable.button, R.drawable.button, R.drawable.button, R.drawable.button));

        GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 2);
        Adapter adapter = new Adapter(MainActivity.this, images, titles, ids);

        RecyclerView recycler_view = findViewById(R.id.recyclerView);
        recycler_view.setLayoutManager(manager);
        recycler_view.setAdapter(adapter);
    }
}