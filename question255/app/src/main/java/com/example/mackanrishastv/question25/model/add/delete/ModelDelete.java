package com.example.mackanrishastv.question25.model.add.delete;


import com.example.mackanrishastv.question25.ApplicationContextProvider;
import com.example.mackanrishastv.question25.DatabaseAccess;

public class ModelDelete  {

    private ModelResponseToPresenterDeleteListener modelResponseToPresenterDeleteListener;
    private ApplicationContextProvider applicationContextProvider;
    private DatabaseAccess databaseAccess;

    public ModelDelete(ModelResponseToPresenterDeleteListener modelResponseToPresenterDeleteListener){
        this.modelResponseToPresenterDeleteListener = modelResponseToPresenterDeleteListener;
    }

    public void deleteTodo(int todo_id){
        databaseAccess = DatabaseAccess.getInstance(applicationContextProvider.getsContext());
        databaseAccess.open();

        String id = String.valueOf(todo_id);
        databaseAccess.deleteTodo(id);

        modelResponseToPresenterDeleteListener.onDeleteSuccess();

    }
}
