package com.example.mackanrishastv.question25;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mackanrishastv.question25.Database.DatabaseHelper;
import com.example.mackanrishastv.question25.Model.Edit.ToDoEditActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ToDoListView, View.OnClickListener,DeleteDialogFragment.DeleteDialogListener {

    private ToDoRecyclerViewAdapter toDoRecyclerViewAdapter;
    private ToDoListPresenter presenter;
    private List<ToDo> toDoList;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.addButton);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.todoListView);

        toDoRecyclerViewAdapter = new ToDoRecyclerViewAdapter();
        presenter = new ToDoListPresenterImpl(new DatabaseHelper(this),this);
        toDoRecyclerViewAdapter.setListener((ToDoRecyclerViewAdapter.TodoAdapterListener) presenter);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(toDoRecyclerViewAdapter);


        button.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ToDoEditActivity.class);
        intent.putExtra("status","newTodo");
        startActivity(intent);
    }

    @Override
    public void reloadList() {
        presenter.selectAll();
    }

    @Override
    public void navigateToEditView(ToDo todo) {
        Intent intent = new Intent(getApplication(), ToDoEditActivity.class);
        intent.putExtra("status","updateTodo");
        intent.putExtra("todo",todo);
        startActivity(intent);
    }

    @Override
    public void showDeleteDialog(int position) {
        this.position = position;
        Log.i("System.out", String.valueOf(position));
        DeleteDialogFragment dialogFragment = new DeleteDialogFragment();
        dialogFragment.setListener(this);
        dialogFragment.show(getFragmentManager(),"delete");

    }

    @Override
    public void printToDoList(List<ToDo> todoList) {
        this.toDoList = todoList;
        toDoRecyclerViewAdapter.setTodoList(this.toDoList);
        toDoRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void insertSuccessfully() {
        presenter.onResume();
    }

    @Override
    public void insertFailed() {
        Toast.makeText(getApplication(), "Delete Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickOk() {
        presenter.deleteRow(toDoList.get(position).getTodoID());
    }
}
