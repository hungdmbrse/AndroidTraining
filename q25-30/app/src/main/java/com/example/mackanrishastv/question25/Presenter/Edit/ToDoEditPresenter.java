package com.example.mackanrishastv.question25.Presenter.Edit;

import android.database.sqlite.SQLiteDatabase;

import com.example.mackanrishastv.question25.Database.DatabaseViewInterface;
import com.example.mackanrishastv.question25.Model.Edit.ToDoEditView;
import com.example.mackanrishastv.question25.ToDo;
import com.example.mackanrishastv.question25.Database.DatabaseHelper;
import com.example.mackanrishastv.question25.Database.DatabaseHandler;

import java.util.List;

public class ToDoEditPresenter implements DatabaseViewInterface {
    DatabaseHelper dbHelper;
    ToDoEditView toDoEditView;
    SQLiteDatabase db;


    public ToDoEditPresenter(DatabaseHelper dbHelper, ToDoEditView toDoEditView) {
        this.dbHelper = dbHelper;
        this.toDoEditView = toDoEditView;
        this.db = dbHelper.getWritableDatabase();
    }

    public void onClickButton(ToDo todo) {
        String title = toDoEditView.getTitleString();
        if(title.isEmpty()){
            toDoEditView.showTitleError("Please enter title");
            return;
        }

        String content = toDoEditView.getContentString();

        if(content.isEmpty()){
            toDoEditView.showContentError("Please enter content");
            return;
        }

        String limitDate = toDoEditView.getLimitDateString();

        if(todo!=null){
            DatabaseHandler.update(db,todo.getTodoID(),title,content, limitDate,this);
        }else {
            DatabaseHandler.insert(db,title,content,limitDate,this);
        }

    }

    @Override
    public void insertDatabaseSuccessfully() {
        toDoEditView.insertSuccessfully();
    }

    @Override
    public void insertDatabaseFailed() {
        toDoEditView.insertFailed();
    }

    @Override
    public void selectedDatabaseSuccessfully(List<ToDo> toDoDataList) {

    }
}
