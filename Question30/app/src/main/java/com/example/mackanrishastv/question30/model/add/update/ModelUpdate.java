package com.example.mackanrishastv.question30.model.add.update;

import com.example.mackanrishastv.question30.DatabaseAccess;
import com.example.mackanrishastv.question30.Todo;

public class ModelUpdate {

    ModelResponseToPresenterUpdateListener modelResponseToPresenterUpdateListener;

    public ModelUpdate(ModelResponseToPresenterUpdateListener modelResponseToPresenterUpdateListener){
        this.modelResponseToPresenterUpdateListener = modelResponseToPresenterUpdateListener;
    }

    public void handelUpdate(int todo_id, String title, String content, String update_date, DatabaseAccess databaseAccess){
        String updateSQL = ("UPDATE tr_todo SET todo_title = '" + title + "', todo_content = '"
                + content + "', modified = '" + update_date + "' WHERE todo_id = '" +
                todo_id + "'");

        databaseAccess.updateTodo(todo_id, title, content, update_date);
        modelResponseToPresenterUpdateListener.onUpdateSuccess();

    }

}
