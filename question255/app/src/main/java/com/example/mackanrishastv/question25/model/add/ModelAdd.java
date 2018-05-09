package com.example.mackanrishastv.question25.model.add;

import com.example.mackanrishastv.question25.ApplicationContextProvider;
import com.example.mackanrishastv.question25.DatabaseAccess;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelAdd {

    ModelResponseToPresenterAddListener modelResponseToPresenterListener;
    private ApplicationContextProvider applicationContextProvider;
    private DatabaseAccess databaseAccess;

    public ModelAdd(ModelResponseToPresenterAddListener modelResponseToPresenterListener){
        this.modelResponseToPresenterListener = modelResponseToPresenterListener;

    }

    public void handelAdd(String title, String contents, String limit_date){
        databaseAccess = DatabaseAccess.getInstance(applicationContextProvider.getsContext());
        if(title.equals("")){
            modelResponseToPresenterListener.onAddFail();
        } else {
            String created = getCurrentDate();

            databaseAccess.open();
            databaseAccess.addTodo(title, contents, created, "", limit_date);
            databaseAccess.close();

            modelResponseToPresenterListener.onAddSuccess();
        }

    }

    public String getCurrentDate(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String created = sdf.format(new Date());

        return created;
    }
}
