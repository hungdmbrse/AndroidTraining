package com.example.mackanrishastv.question30;

public class Todo {

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTodo_title() {
        return todo_title;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }

    public String getTodo_contents() {
        return todo_contents;
    }

    public void setTodo_contents(String todo_contents) {
        this.todo_contents = todo_contents;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLimit_date() {
        return limit_date;
    }

    public void setLimit_date(String limit_date) {
        this.limit_date = limit_date;
    }

    private int todo_id;
    private String todo_title;
    private String todo_contents;
    private String created;
    private String modified;
    private String limit_date;

    public Todo(int todo_id, String todo_title, String todo_contents, String created, String modified, String limit_date) {
        this.todo_id = todo_id;
        this.todo_title = todo_title;
        this.todo_contents = todo_contents;
        this.created = created;
        this.modified = modified;
        this.limit_date = limit_date;
    }

    public Todo(){

    }
}
