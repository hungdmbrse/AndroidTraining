package com.example.mackanrishastv.question25.presenter.add;


import com.example.mackanrishastv.question25.model.add.ModelAdd;
import com.example.mackanrishastv.question25.model.add.ModelResponseToPresenterAddListener;

public class PresenterAdd implements ModelResponseToPresenterAddListener {

    private ModelAdd modelAdd;
    private PresenterResponseToViewAddListener presenterResponseToViewAddListenerCallback;

    public PresenterAdd(PresenterResponseToViewAddListener presenterResponseToViewAddListenerCallback){
        this.presenterResponseToViewAddListenerCallback = presenterResponseToViewAddListenerCallback;
    }


    public void receivedHandleAdd(String title, String contents, String limit_date){
        modelAdd = new ModelAdd(this);
        modelAdd.handelAdd(title, contents, limit_date);
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
