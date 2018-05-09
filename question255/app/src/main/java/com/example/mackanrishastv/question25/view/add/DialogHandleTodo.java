package com.example.mackanrishastv.question25.view.add;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mackanrishastv.question25.DatabaseAccess;
import com.example.mackanrishastv.question25.MainActivity;
import com.example.mackanrishastv.question25.R;
import com.example.mackanrishastv.question25.presenter.add.PresenterAdd;
import com.example.mackanrishastv.question25.presenter.add.PresenterResponseToViewAddListener;

import java.util.Calendar;


public class DialogHandleTodo extends DialogFragment implements View.OnClickListener, PresenterResponseToViewAddListener {

    private PresenterAdd presenterAdd;

    private static String action;
    private EditText edtTextAddTitle, edtTextAddContents;
    private TextView txtViewAddLimitDate;
    private Button btnAddTodo, btnAddCancel;



    final String[] addLimitDate = new String[1];

    public DialogHandleTodo() {

    }

    public static DialogHandleTodo newInstance(String title) {

        DialogHandleTodo dialogHandleTodo = new DialogHandleTodo();
        Bundle args = new Bundle();
        args.putString("title", title);
        action = title;
        dialogHandleTodo.setArguments(args);
        return dialogHandleTodo;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dialog_handle_todo, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtTextAddTitle = (EditText) view.findViewById(R.id.edtTextAddTitle);
        edtTextAddContents = (EditText) view.findViewById(R.id.edtTextAddContents);
        txtViewAddLimitDate = (TextView) view.findViewById(R.id.txtViewAddLimitDate);
        btnAddTodo = (Button) view.findViewById(R.id.btnAddTodo);
        btnAddCancel = (Button) view.findViewById(R.id.btnAddCancel);

        btnAddTodo.setOnClickListener(this);
        btnAddCancel.setOnClickListener(this);
        txtViewAddLimitDate.setOnClickListener(this);

        presenterAdd = new PresenterAdd(this);

        String title = getArguments().getString("title", "Enter name");
        getDialog().setTitle(title);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddTodo:
                if(action.equals("add")) {

                    String addTitle = edtTextAddTitle.getText().toString();
                    String addContent = edtTextAddContents.getText().toString();
                    String addDeadline = addLimitDate[0];

                    presenterAdd.receivedHandleAdd(addTitle, addContent, addDeadline);

                }
                break;
            case R.id.btnAddCancel:
                    this.dismiss();
                break;
            case R.id.txtViewAddLimitDate:
                getLimitDate();
                break;
        }
    }

    public void getLimitDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtViewAddLimitDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                addLimitDate[0] = year + "/" + (month + 1) + "/" + dayOfMonth;
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    @Override
    public void onAddSuccess() {
        Toast.makeText(getActivity(), "Added Successfully, Reopen to refesh Todo", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    @Override
    public void onAddFail() {

    }
}
