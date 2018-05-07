package com.example.mackanrishastv.question30.presenter.add;

import com.example.mackanrishastv.question30.DatabaseAccess;
import com.example.mackanrishastv.question30.model.add.ModelAdd;
import com.example.mackanrishastv.question30.model.add.ModelResponseToPresenterAddListener;

public class PresenterAdd implements ModelResponseToPresenterAddListener {

    private ModelAdd modelAdd;
    private PresenterResponseToViewAddListener presenterResponseToViewAddListenerCallback;

    public PresenterAdd(PresenterResponseToViewAddListener presenterResponseToViewAddListenerCallback){
        this.presenterResponseToViewAddListenerCallback = presenterResponseToViewAddListenerCallback;
    }

    public void receivedHandleAdd(String title, String contents, String limit_date, DatabaseAccess databaseAccess){
        modelAdd = new ModelAdd(this);
        modelAdd.handelAdd(title, contents, limit_date, databaseAccess);
    }

    @Override
    public void onAddSuccess() {
        presenterResponseToViewAddListenerCallback.onAddSuccess();
    }

    @Override
    public void onAddFail() {
        presenterResponseToViewAddListenerCallback.onAddFail();
    }
}
