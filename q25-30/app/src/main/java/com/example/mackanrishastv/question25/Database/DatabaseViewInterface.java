package com.example.mackanrishastv.question25.Database;

import com.example.mackanrishastv.question25.ToDo;

import java.util.List;

public interface DatabaseViewInterface {
    void insertDatabaseSuccessfully();

    void insertDatabaseFailed();

    void selectedDatabaseSuccessfully(List<ToDo> toDoDataList);
}
