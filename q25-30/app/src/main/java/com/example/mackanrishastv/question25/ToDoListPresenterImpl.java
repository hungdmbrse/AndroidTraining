package com.example.mackanrishastv.question25;

import android.database.sqlite.SQLiteDatabase;

import com.example.mackanrishastv.question25.Database.DatabaseHandler;
import com.example.mackanrishastv.question25.Database.DatabaseHelper;
import com.example.mackanrishastv.question25.ToDo;
import com.example.mackanrishastv.question25.Database.DatabaseViewInterface;

import java.util.List;

public class ToDoListPresenterImpl implements ToDoListPresenter,
        ToDoRecyclerViewAdapter.TodoAdapterListener,
        DatabaseViewInterface{

    private ToDoListView toDoListView;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public ToDoListPresenterImpl(DatabaseHelper dbHelper, ToDoListView toDoListView) {
        this.toDoListView = toDoListView;
        this.dbHelper = dbHelper;
        this.db = dbHelper.getWritableDatabase();
    }

    @Override
    public void onResume() {
        if (toDoListView != null){
            toDoListView.reloadList();
        }
    }

    @Override
    public void selectAll() {
        DatabaseHandler.select(db,this);
    }

    @Override
    public void deleteRow(int todoID) {
        DatabaseHandler.delete(db,todoID,this);
    }


    @Override
    public void selectedTodo(ToDo todo) {
        if (toDoListView != null){
            toDoListView.navigateToEditView(todo);
        }
    }

    @Override
    public void onLongClicked(int position) {
        if (toDoListView != null){
            toDoListView.showDeleteDialog(position);
        }
    }

    @Override
    public void insertDatabaseSuccessfully() {
        toDoListView.insertSuccessfully();
    }

    @Override
    public void insertDatabaseFailed() {

    }

    @Override
    public void selectedDatabaseSuccessfully(List<ToDo> toDoDataList) {
        toDoListView.printToDoList(toDoDataList);
    }
}
