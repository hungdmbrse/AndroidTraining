package com.example.mackanrishastv.question25.model.add.update;


import com.example.mackanrishastv.question25.ApplicationContextProvider;
import com.example.mackanrishastv.question25.DatabaseAccess;

public class ModelUpdate {

    ModelResponseToPresenterUpdateListener modelResponseToPresenterUpdateListener;
    private ApplicationContextProvider applicationContextProvider;
    private DatabaseAccess databaseAccess;

    public ModelUpdate(ModelResponseToPresenterUpdateListener modelResponseToPresenterUpdateListener){
        this.modelResponseToPresenterUpdateListener = modelResponseToPresenterUpdateListener;
    }

    public void handelUpdate(int todo_id, String title, String content, String update_date){
        String updateSQL = ("UPDATE tr_todo SET todo_title = '" + title + "', todo_content = '"
                + content + "', modified = '" + update_date + "' WHERE todo_id = '" +
                todo_id + "'");
        databaseAccess = DatabaseAccess.getInstance(applicationContextProvider.getsContext());
        databaseAccess.updateTodo(todo_id, title, content, update_date);
        modelResponseToPresenterUpdateListener.onUpdateSuccess();

    }

}
