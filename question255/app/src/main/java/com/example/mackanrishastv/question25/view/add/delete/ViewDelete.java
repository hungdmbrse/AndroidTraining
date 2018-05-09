package com.example.mackanrishastv.question25.view.add.delete;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mackanrishastv.question25.presenter.add.delete.PresenterDelete;
import com.example.mackanrishastv.question25.presenter.add.delete.PresenterResponseToViewDeleteListener;


public class ViewDelete extends android.support.v4.app.DialogFragment implements PresenterResponseToViewDeleteListener {

    private PresenterDelete presenterDelete;

    public ViewDelete(){

    }

    public static ViewDelete newInstance(String title) {

        ViewDelete viewDelete = new ViewDelete();
        Bundle args = new Bundle();
        args.putString("title", title);
        viewDelete.setArguments(args);
        return viewDelete;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage("This todo will be deleted ?");

        presenterDelete = new PresenterDelete(this);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle bundle = getArguments();
                int todo_id = bundle.getInt("todo_id");
                presenterDelete.receiveHandleDelete(todo_id);
            }
        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return alertDialogBuilder.create();
    }

    @Override
    public void onDeleteSuccess() {
        Toast.makeText(getActivity(), "Deleted", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    @Override
    public void onDeleteFail() {

    }
}
