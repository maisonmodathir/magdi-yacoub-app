package com.example.app;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class  User {

    @PrimaryKey(autoGenerate = true)
    public int userID;
    public String firstName,lastName,email,birthDate,password;
    public Double weight,height1;
}

