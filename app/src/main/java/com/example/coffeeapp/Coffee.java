package com.example.coffeeapp;

import androidx.annotation.NonNull;

public class Coffee extends Models{
    private int id;
    private String name;
    private int price;
    private int volume;
    private boolean season_product = false;

    Coffee(int id, String name, int price, int volume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    @NonNull
    @Override
    public String toString() {
        return "<Coffee" + this.id + " " + this.season_product + ": " + this.name + ", " + this.volume + "мл, " + this.price + ">";
    }

    public void setSeasonProduct(boolean value) {
        this.season_product = value;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() { return this.price; }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isSeasonProduct() {
        return this.season_product;
    }
}
