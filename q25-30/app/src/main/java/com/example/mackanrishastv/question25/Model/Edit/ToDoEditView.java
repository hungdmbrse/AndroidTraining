package com.example.mackanrishastv.question25.Model.Edit;

public interface ToDoEditView {

    String getLimitDateString();

    String getTitleString();

    String getContentString();

    void showTitleError(String titleError);

    void showContentError(String contentError);

    void insertSuccessfully();

    void insertFailed();
}
