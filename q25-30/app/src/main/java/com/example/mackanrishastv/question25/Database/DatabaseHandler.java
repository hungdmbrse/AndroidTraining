package com.example.mackanrishastv.question25.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mackanrishastv.question25.Database.DatabaseConstructor.ToDoEntry;
import com.example.mackanrishastv.question25.ToDo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DatabaseHandler {


    public static void insert(SQLiteDatabase db, String title, String content,String limitDate,DatabaseViewInterface databaseViewInterface){
        String nowDate = getNowDate();
        String limited = limitDate;

        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoEntry.COLUMN_TODO_TITLE, title);
        contentValues.put(ToDoEntry.COLUMN_TODO_CONTENTS, content);
        contentValues.put(ToDoEntry.COLUMN_CREATED, nowDate);
        contentValues.put(ToDoEntry.COLUMN_MODIFIED, nowDate);
        contentValues.put(ToDoEntry.COLUMN_LIMIT_DATE, limited);
        contentValues.put(ToDoEntry.COLUMN_DELETE_FLG, 0);

        long ret;
        try {
            ret = db.insert(ToDoEntry.TABLE_TODO, null, contentValues);
        } finally {

        }
        if (ret != -1L){
            databaseViewInterface.insertDatabaseSuccessfully();
        }else {
            databaseViewInterface.insertDatabaseFailed();
        }

    }

    public static void update(SQLiteDatabase db,int todoID, String title, String content,String limitDate,DatabaseViewInterface databaseViewInterface){
        String nowDate = getNowDate();
        String limited = limitDate;

        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoEntry.COLUMN_TODO_TITLE, title);
        contentValues.put(ToDoEntry.COLUMN_TODO_CONTENTS, content);
        contentValues.put(ToDoEntry.COLUMN_MODIFIED, nowDate);
        contentValues.put(ToDoEntry.COLUMN_LIMIT_DATE, limited);


        int ret;
        try {
            String whereClause = ToDoEntry.COLUMN_TODO_ID + " = ?";
            String[] whereArgs = {String.valueOf(todoID)};

            ret = db.update(ToDoEntry.TABLE_TODO,contentValues,whereClause,whereArgs);
        } finally {
        }

        if (ret != -1L){
            databaseViewInterface.insertDatabaseSuccessfully();
        }else {
            databaseViewInterface.insertDatabaseFailed();
        }

    }

    public static void select(SQLiteDatabase db,DatabaseViewInterface databaseViewInterface){
        List<ToDo> todoList = new ArrayList<>();

        String sql = "select * from " + ToDoEntry.TABLE_TODO +
                " where " + ToDoEntry.COLUMN_DELETE_FLG + " = 0" +
                " order by " + ToDoEntry.COLUMN_LIMIT_DATE + " desc ";
        Cursor cursor = db.rawQuery(sql, null);
        try {
            while (cursor.moveToNext()) {
                int todoID = cursor.getInt(0);
                String title = cursor.getString(1);
                String content = cursor.getString(2);
                String limit = cursor.getString(5);

                ToDo todo = new ToDo(todoID,title,content,limit);
                todoList.add(todo);
            }

        } finally {
            cursor.close();
        }
        databaseViewInterface.selectedDatabaseSuccessfully(todoList);

//        return todoList;
    }

    public static void delete(SQLiteDatabase db,int todoID,DatabaseViewInterface databaseViewInterface){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoEntry.COLUMN_DELETE_FLG, 1);

        int ret;
        try {
            String whereClause = ToDoEntry.COLUMN_TODO_ID + " = ?";
            String[] whereArgs = {String.valueOf(todoID)};
            ret = db.update(ToDoEntry.TABLE_TODO,contentValues, whereClause, whereArgs);
        } finally {
        }

        if (ret != -1){
            databaseViewInterface.insertDatabaseSuccessfully();
        }else {
            databaseViewInterface.insertDatabaseFailed();
        }
    }

    private static String getNowDate(){
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }

    private static String getLimitDateFrom(String dateStr){
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.DATE,7);
        Date limitDate = new Date(calendar.getTimeInMillis());
        return df.format(limitDate);
    }
}
