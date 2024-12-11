package com.example.coffeeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList images, titles, ids;
    Context context;

    public Adapter(Context ctx, ArrayList images, ArrayList titles, ArrayList ids) {
        this.context = ctx;
        this.images = images;
        this.titles = titles;
        this.ids = ids;
    }

    public Context getContext() { return this.context; }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.image.setImageResource((int) images.get(position));
        int id = (int) ids.get(position);
        holder.text.setText((String) titles.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product_page = new Intent(getContext(), ProductPageActivity.class);
                product_page.putExtra("prod_id", id);
                getContext().startActivity(product_page);
            }
        });

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        Integer id;

        public ViewHolder(View view) {
            super(view);
            image = itemView.findViewById(R.id.listImageView);
            text = itemView.findViewById(R.id.listTitle);
            id = null;
        }
    }
}
