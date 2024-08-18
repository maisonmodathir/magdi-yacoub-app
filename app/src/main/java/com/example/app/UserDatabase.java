package com.example.app;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase{
    public abstract UserDAO getUserDAO();
    private static UserDatabase ourInstance;
    public static UserDatabase getInstance(Context context){
        if(ourInstance==null){
            ourInstance = Room.databaseBuilder(context,UserDatabase.class,"users.db")
                    .createFromAsset("databases/users.db")
                    .allowMainThreadQueries().build();
        }
        return  ourInstance;
    }
}
