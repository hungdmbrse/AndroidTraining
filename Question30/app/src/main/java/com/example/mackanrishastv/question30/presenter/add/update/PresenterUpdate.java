package com.example.mackanrishastv.question30.presenter.add.update;

import com.example.mackanrishastv.question30.DatabaseAccess;
import com.example.mackanrishastv.question30.Todo;
import com.example.mackanrishastv.question30.model.add.update.ModelResponseToPresenterUpdateListener;
import com.example.mackanrishastv.question30.model.add.update.ModelUpdate;

public class PresenterUpdate implements ModelResponseToPresenterUpdateListener {

    private PresenterResponseToViewUpdateListener presenterResponseToViewUpdateListener;
    private ModelUpdate modelUpdate;

    public PresenterUpdate(PresenterResponseToViewUpdateListener presenterResponseToViewUpdateListener){
        this.presenterResponseToViewUpdateListener = presenterResponseToViewUpdateListener;
    }

    public void receiveHandleUpdate(int todo_id, String title, String content, String update_date, DatabaseAccess databaseAccess){
        modelUpdate = new ModelUpdate(this);
        modelUpdate.handelUpdate(todo_id, title, content, update_date, databaseAccess);
    }

    @Override
    public void onUpdateSuccess() {
        presenterResponseToViewUpdateListener.onUpdateSuccess();
    }

    @Override
    public void onUpdateFail() {

    }
}
