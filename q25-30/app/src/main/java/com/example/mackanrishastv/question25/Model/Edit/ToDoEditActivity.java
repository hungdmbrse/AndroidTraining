package com.example.mackanrishastv.question25.Model.Edit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mackanrishastv.question25.Presenter.Edit.ToDoEditPresenter;
import com.example.mackanrishastv.question25.ToDo;
import com.example.mackanrishastv.question25.Database.DatabaseHelper;
import com.example.mackanrishastv.question25.R;

import java.util.Calendar;

public class ToDoEditActivity extends Activity implements ToDoEditView, View.OnClickListener{
    Toolbar toolbar;
    Button registerButton;
    Button btnCancel;
    EditText titleEditText;
    EditText contentEditText;
    TextView textViewLimitDate;
    ToDoEditPresenter presenter;

    ToDo todo;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_edit);

        setupResources();

        checkStatus();

        textViewLimitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ToDoEditActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textViewLimitDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        registerButton.setOnClickListener(this);

        presenter = new ToDoEditPresenter(new DatabaseHelper(this),this);
    }

    private void setupResources(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleEditText = (EditText) findViewById(R.id.edtTextAddTitle);
        contentEditText = (EditText) findViewById(R.id.edtTextAddContents);
        textViewLimitDate = (TextView) findViewById(R.id.txtViewAddLimitDate);
        registerButton = findViewById(R.id.btnAddTodo);
        btnCancel = findViewById(R.id.btnAddCancel);
    }

    private void checkStatus(){
        status = getIntent().getStringExtra("status");


        if(status.equals("updateTodo")){
            todo = (ToDo) getIntent().getSerializableExtra("todo");
            toolbar.setTitle(todo.getTitle());
            titleEditText.setText(todo.getTitle());
            contentEditText.setText(todo.getContent());
            textViewLimitDate.setText(todo.getLimit());
            registerButton.setText("Update");
        } else {
            toolbar.setTitle("Create New");
        }
    }

    @Override
    public void onClick(View view) {
        if (todo!=null){
            presenter.onClickButton(todo);
        } else {
            presenter.onClickButton(null);
        }
    }


    @Override
    public String getLimitDateString() {
        return textViewLimitDate.getText().toString();
    }

    @Override
    public String getTitleString() {
        return titleEditText.getText().toString();
    }

    @Override
    public String getContentString() {
        return contentEditText.getText().toString();
    }

    @Override
    public void showTitleError(String titleError) {
        titleEditText.setError(titleError);
    }

    @Override
    public void showContentError(String contentError) {
        contentEditText.setError(contentError);
    }

    @Override
    public void insertSuccessfully() {
        finish();
    }

    @Override
    public void insertFailed() {
        Toast.makeText(this, "Database Inserted Failed", Toast.LENGTH_SHORT).show();
    }
}
