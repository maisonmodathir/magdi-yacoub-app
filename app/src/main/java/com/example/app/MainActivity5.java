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

public class MainActivity5 extends AppCompatActivity {
Spinner genderText;
EditText confirmPasswordText,password1Text,heightText,weightText,birthDateText,
        email1Text,firstNameText,LastNameText;
ArrayList<String> gender=new ArrayList<>();
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
        setContentView(R.layout.activity_main5);

        genderText=findViewById(R.id.genderText);
        confirmPasswordText=findViewById(R.id.confirmPasswordText);
        password1Text=findViewById(R.id.password1Text);
        heightText=findViewById(R.id.heightText);
        weightText=findViewById(R.id.weightText);
        birthDateText=findViewById(R.id.birthDateText);
        email1Text=findViewById(R.id.email1Text);
        firstNameText=findViewById(R.id.firstNameText);
        LastNameText=findViewById(R.id.LastNameText);

        Collections.addAll(gender," ","Male","Female");
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,gender);
        genderText.setAdapter(adapter);
    }


    public void backSignIn(View view) {
        Intent  in = new Intent(this, MainActivity4.class);
        startActivity(in);
    }

    public void sign_up(View view) {
        String confirmPass = confirmPasswordText.getText().toString();
        String password = password1Text.getText().toString();
        String height = heightText.getText().toString();
        String weight = weightText.getText().toString();
        String birthDate = birthDateText.getText().toString();
        String email = email1Text.getText().toString();
        String firstName = firstNameText.getText().toString();
        String lastName = LastNameText.getText().toString();


        if (!confirmPass.equals("") && !password.equals("") && !height.equals("")
                && !weight.equals("") && !birthDate.equals("") && !email.equals("")
                && !firstName.equals("") && !lastName.equals("")) {
            if (confirmPass.equals(password)) {

                User newUser = new User();
                newUser.firstName = firstName;
                newUser.lastName = lastName;
                newUser.email = email;
                newUser.password = password;
                newUser.height1 = Double.parseDouble(height);
                newUser.weight = Double.parseDouble(weight);
                newUser.birthDate = birthDate;
                UserDatabase.getInstance(this).getUserDAO().insertUser(newUser);

                Toast.makeText(this, "signed up successfully!", Toast.LENGTH_LONG).show();
                Intent in = new Intent(this, MainActivity6.class);
                startActivity(in);
            }
         else
             Toast.makeText(this, "check the confirmation password", Toast.LENGTH_LONG).show();
    }else
            Toast.makeText(this,"please fill all fields",Toast.LENGTH_LONG).show();
    }
}