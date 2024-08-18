package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity11 extends AppCompatActivity {
    public  static  final String ID1="ID";
    private int id;
    EditText editTextText7,editTextText20,editTextText21;
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
        setContentView(R.layout.activity_main11);
        editTextText7=findViewById(R.id.editTextText7);
        editTextText20=findViewById(R.id.editTextText20);
        editTextText21=findViewById(R.id.editTextText21);
        Intent i = getIntent();
        id=i.getIntExtra(ID1,-1);
    }
    public void account(View view) {
        User currentUser = UserDatabase.getInstance(this).getUserDAO().getUserById(id);
        String oldPassword = editTextText7.getText().toString();
        String newPassword = editTextText20.getText().toString();
        String confirmPassword = editTextText21.getText().toString();

        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "New passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        if ( !currentUser.password.equals(oldPassword)) {
            // Invalid old password or user not found
            Toast.makeText(this, "Incorrect old password", Toast.LENGTH_SHORT).show();
            return;
        }
        currentUser.password = newPassword;
        UserDatabase.getInstance(this).getUserDAO().updateUser(currentUser);
        Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this, MainActivity9.class);
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
}