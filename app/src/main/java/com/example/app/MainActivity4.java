package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
public class MainActivity4 extends AppCompatActivity {
    EditText emailText,passText;
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
        setContentView(R.layout.activity_main4);
        emailText=findViewById(R.id.emailText);
        passText=findViewById(R.id.passText);
    }

    public void sign_up(View view) {
        Intent in = new Intent(this, MainActivity5.class);
        startActivity(in);
    }

    public void signIn(View view) {
        boolean check=false;
        int user_id=-1;
        String firstName="";
        String lastName="";
        String email=emailText.getText().toString().trim();
        String password=passText.getText().toString().trim();
        List<String> emailList=UserDatabase.getInstance(this).getUserDAO().selectEmail();
        List<String> passwordList=UserDatabase.getInstance(this).getUserDAO().selectPassword();
        List<Integer> userIDList=UserDatabase.getInstance(this).getUserDAO().selectUserID();
        List<String> firstNameList=UserDatabase.getInstance(this).getUserDAO().selectFirstName();
        List<String> lastNameList=UserDatabase.getInstance(this).getUserDAO().selectLastName();
        if(email.isEmpty()||password.isEmpty())
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show();
            else{
            for (int i = 0; i < emailList.size(); i++) {
                if (email.equals(emailList.get(i)) && password.equals(passwordList.get(i))) {
                    check = true;
                    user_id=userIDList.get(i);
                    firstName=firstNameList.get(i);
                    lastName=lastNameList.get(i);
                    break;
                }
            }
            if (check) {
                Intent in = new Intent(this, MainActivity6.class);
                in.putExtra(MainActivity6.Name,firstName+" "+lastName);
                in.putExtra(MainActivity6.ID,user_id);
                startActivity(in);
            } else
                Toast.makeText(this, "Incorrect email or password. Try again", Toast.LENGTH_LONG).show();
        }
    }

}
