package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {
public  static  final String ID1="ID";
private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the navigation bar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Set your content view
        setContentView(R.layout.activity_main9);
        Intent i = getIntent();
        id=i.getIntExtra(ID1,-1);
    }


    public void edit_profile(View view) {
        Intent in = new Intent(this, MainActivity10.class);
        in.putExtra(MainActivity10.ID1,id);
        startActivity(in);
    }

    public void home_page(View view) {
        Intent in = new Intent(this, MainActivity6.class);
        startActivity(in);
    }

    public void med(View view) {
        Intent in = new Intent(this, MainActivity12.class);
        startActivity(in);
    }

    public void reset_password(View view) {
        Intent in = new Intent(this, MainActivity11.class);
        in.putExtra(MainActivity11.ID1,id);
        startActivity(in);
    }

    public void logOut(View view) {
        if (id != -1) {
            User currentUser = UserDatabase.getInstance(this).getUserDAO().getUserById(id);
            if (currentUser != null) {
                UserDatabase.getInstance(this).getUserDAO().deleteUser(currentUser);
                Toast.makeText(this, "Logged out successfully", Toast.LENGTH_LONG).show();
                Intent in = new Intent(this, MainActivity4.class);
                startActivity(in);
                finish(); // Close the current activity
            } else {
                Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No user session found", Toast.LENGTH_LONG).show();
        }

    }
}