package com.dicoding.githubusersub3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dicoding.githubusersub3.data.User;

import java.util.ArrayList;

import static com.dicoding.githubusersub3.database.DatabaseContract.UserColumns.AVATAR;
import static com.dicoding.githubusersub3.database.DatabaseContract.UserColumns.ID;
import static com.dicoding.githubusersub3.database.DatabaseContract.UserColumns.TABLE_USER_NAME;
import static com.dicoding.githubusersub3.database.DatabaseContract.UserColumns.URL;
import static com.dicoding.githubusersub3.database.DatabaseContract.UserColumns.USERNAME;

public class UserHelper {
    private static final String DATABASE_TABLE = TABLE_USER_NAME;
    private static DatabaseHelper databaseHelper;
    private static UserHelper INST;
    private static SQLiteDatabase database;

    public UserHelper(Context c) {
        databaseHelper = new DatabaseHelper(c);
    }

    public static UserHelper getInstance(Context c) {
        if (INST == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INST == null) {
                    INST = new UserHelper(c);
                }
            }
        }
        return INST;
    }

    public void open() throws SQLException {
//        database = DatabaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (database.isOpen())
            database.close();
    }

    public Cursor queryAll() {
        return database.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                ID+ " ASC");
    }

    public Cursor queryById(String id) {
        return database.query(DATABASE_TABLE, null
                , ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }
    public ArrayList<User> getDataUser(){
        ArrayList<User> userGithubList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE,null,
                null,
                null,
                null,
                null,
                USERNAME + " ASC",
                null);
        cursor.moveToFirst();
        User user;
        if (cursor.getCount() > 0){
            do {
                user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
                user.setLogin(cursor.getString(cursor.getColumnIndexOrThrow(USERNAME)));
                user.setAvatarUrl(cursor.getString(cursor.getColumnIndexOrThrow(AVATAR)));
                user.setHtmlUrl(cursor.getString(cursor.getColumnIndexOrThrow(URL)));
                userGithubList.add(user);
                cursor.moveToNext();
            }while (!cursor.isAfterLast());
        }cursor.close();
        return userGithubList;
    }

    public long userInsert(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,user.getId());
        contentValues.put(USERNAME,user.getLogin());
        contentValues.put(URL,user.getHtmlUrl());
        contentValues.put(AVATAR,user.getAvatarUrl());

        return database.insert(DATABASE_TABLE,null, contentValues);

    }

    public int userDelete(String id){
        return database.delete(TABLE_USER_NAME,ID + " = '" + id + "'", null);
    }


    public int DeleteProvider(String id) {
        return database.delete(TABLE_USER_NAME, ID+ "=?",new String[]{id});
    }
    public int UpdateProvider(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, ID + " =?", new String[]{id});
    }
    public long InsertProvider(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }
}
