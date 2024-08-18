package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity10 extends AppCompatActivity {
    public  static  final String ID1="ID";
    private int id;
    Spinner genderSelection1;
    EditText editTextText12,editTextText15,editTextText16,editTextText17,editTextText18,editTextText19;
    ArrayList<String> gender1=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
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
        setContentView(R.layout.activity_main10);
        genderSelection1=findViewById(R.id.genderSelection1);
        editTextText12=findViewById(R.id.editTextText12);
        editTextText15=findViewById(R.id.editTextText15);
        editTextText16=findViewById(R.id.editTextText16);
        editTextText17=findViewById(R.id.editTextText17);
        editTextText18=findViewById(R.id.editTextText18);
        editTextText19=findViewById(R.id.editTextText19);
        Collections.addAll(gender1," ","Male","Female");
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,gender1);
        genderSelection1.setAdapter(adapter);
        Intent i = getIntent();
        id=i.getIntExtra(ID1,-1);
    }

    public void account(View view) {
        String firstName = editTextText12.getText().toString();
        String lastName = editTextText15.getText().toString();
        String email = editTextText16.getText().toString();
        String birthDate = editTextText17.getText().toString();
        String height = editTextText18.getText().toString();
        String weight = editTextText19.getText().toString();
        User currentUser = UserDatabase.getInstance(this).getUserDAO().getUserById(id);

        // Update the current user's data in the database
        currentUser.firstName = firstName;
        currentUser.lastName = lastName;
        currentUser.email = email;
        currentUser.birthDate = birthDate;
        currentUser.height1 = Double.parseDouble(height); // Convert to appropriate type
        currentUser.weight = Double.parseDouble(weight); // Convert to appropriate type

        // Update user in Room database
        UserDatabase.getInstance(this).getUserDAO().updateUser(currentUser);
        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
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