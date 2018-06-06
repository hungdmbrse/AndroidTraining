package com.example.mackanrishastv.question25;

import java.util.List;

public interface ToDoListView {
    void reloadList();

    void navigateToEditView(ToDo todo);

    void showDeleteDialog(int position);

    void printToDoList(List<ToDo> todoList);

    void insertSuccessfully();

    void insertFailed();
}
