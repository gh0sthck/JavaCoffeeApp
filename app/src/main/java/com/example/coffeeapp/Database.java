package com.example.coffeeapp;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    String username = "postgres";
    String password = "root";
    String host = "10.0.2.2"; // For android mapping
    String port = "5432";
    String database = "coffee_app";

    String dsn = "jdbc:postgresql://" + host + ":" + port + "/" + database;
    Connection connection;

    Database() {
        this.connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder().permitAll().build()
            );
            this.connection = DriverManager.getConnection(dsn, username, password);
        } catch (SQLException sql_ex) {
            Log.e("SQLException", sql_ex.getMessage());
            sql_ex.printStackTrace();
        } catch (Exception ex) {
            Log.e("Exception", ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection get_connection() {
        return this.connection;
    }

    public void close_connection() {
        try {
            if (!(this.connection.isClosed())) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            Log.e("SQLException", ex.getMessage());
        }
    }

    public void add_user(User user) throws SQLException {
        Connection conn = this.get_connection();
        PreparedStatement add_user_st = conn.prepareStatement("INSERT INTO users(name, phone) VALUES (?, ?)");
        add_user_st.setString(1, user.getName());
        add_user_st.setString(2, user.getPhone());
        add_user_st.execute();
    }

    public List<Coffee> get_coffies() throws SQLException {
        Connection conn = this.get_connection();
        PreparedStatement get_coffies_st = conn.prepareStatement("SELECT * FROM coffies;");
        get_coffies_st.execute();
        ResultSet coffies = get_coffies_st.getResultSet();

        List<Coffee> result = new ArrayList<>();

        while (coffies.next()) {
            Coffee current_coffee = new Coffee(
                    coffies.getInt(1),
                    coffies.getString(2),
                    coffies.getInt(3),
                    coffies.getInt(4)
                    );
            result.add(current_coffee);
        }
        return result;
    }

    public User get_user(String number) throws SQLException {
        Connection conn = this.get_connection();
        PreparedStatement get_user_st = conn.prepareStatement("SELECT * FROM users WHERE phone = ?;");
        get_user_st.setString(1, number);
        get_user_st.execute();
        ResultSet user = get_user_st.getResultSet();
        if (user.next()) {
            return new User(
                    user.getInt(1),
                    user.getString(2),
                    user.getString(3)
                );
        }
        return null;
    }

    public Coffee get_coffee(int id) throws SQLException {
        Connection conn = this.get_connection();
        PreparedStatement get_coffee_st = conn.prepareStatement("SELECT * FROM coffies WHERE id = ?;");
        get_coffee_st.setInt(1, id);
        get_coffee_st.execute();
        ResultSet coffee = get_coffee_st.getResultSet();
        if (coffee.next()) {
            return new Coffee(
                    coffee.getInt(1),
                    coffee.getString(2),
                    coffee.getInt(3),
                    coffee.getInt(4)
            );
        }

        return null;
    }

}
