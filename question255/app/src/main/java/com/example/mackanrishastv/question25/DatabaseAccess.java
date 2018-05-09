package com.example.mackanrishastv.question25;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;


    //private constructor so that object creation from outside the class is avoided
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return  instance;
    }

    //to open the database
    public  void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(db != null){
            this.db.close();
        }
    }

    public ArrayList<Todo> getListTodo(){
        ArrayList<Todo> arrayListTodo = new ArrayList<>();
        Todo todoTemp = null;

        String sql = "SELECT * FROM tr_todo";
        c = db.rawQuery(sql, new String[]{});

        while (c.moveToNext()){
            int todo_id = c.getInt(0);
            String todo_title = c.getString(1);
            String todo_contents = c.getString(2);
            String created = c.getString(3);
            String modified = c.getString(4);
            String limit_date = c.getString(5);

            todoTemp = new Todo(todo_id, todo_title, todo_contents, created, modified, limit_date);
            arrayListTodo.add(todoTemp);
        }

        return arrayListTodo;
    }

    public void addTodo(String title, String contents, String created, String modified, String limit_date){

        String sql = "INSERT INTO tr_todo VALUES(null, '" + title +
                "', '" + contents + "', '" + created +
                "', ' " + modified + "', '" + limit_date + "')";

        db.execSQL(sql);
    }


}
