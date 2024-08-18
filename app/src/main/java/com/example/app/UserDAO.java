package com.example.app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT email from users")
    List<String> selectEmail();
    @Query("SELECT userID from users")
    List<Integer> selectUserID();
    @Query("SELECT password from users")
    List<String> selectPassword();
    @Query("SELECT firstName from users")
    List<String> selectFirstName();
    @Query("SELECT lastName from users")
    List<String> selectLastName();

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM users WHERE userID = :userID")
    User getUserById(int userID);

}