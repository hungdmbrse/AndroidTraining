package com.example.mackanrishastv.question30.presenter.add.delete;

import com.example.mackanrishastv.question30.model.add.delete.ModelDelete;
import com.example.mackanrishastv.question30.model.add.delete.ModelResponseToPresenterDeleteListener;

public class PresenterDelete implements ModelResponseToPresenterDeleteListener {

    PresenterResponseToViewDeleteListener presenterResponseToViewDeleteListener;
    private ModelDelete modelDelete;

    public PresenterDelete(PresenterResponseToViewDeleteListener presenterResponseToViewDeleteListener){
        this.presenterResponseToViewDeleteListener = presenterResponseToViewDeleteListener;
    }

    public void receiveHandleDelete(int todo_id){
        modelDelete = new ModelDelete(this);
        modelDelete.deleteTodo(todo_id);
    }

    @Override
    public void onDeleteSuccess() {
        presenterResponseToViewDeleteListener.onDeleteSuccess();
    }

    @Override
    public void onDeleteFail() {
        presenterResponseToViewDeleteListener.onDeleteFail();
    }
}
