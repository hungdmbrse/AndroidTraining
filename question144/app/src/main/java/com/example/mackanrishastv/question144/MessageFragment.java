package com.example.mackanrishastv.question144;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private Button btn;
    private EditText editText;
    OnMessageSendListener onMessageSendListener;

    public interface OnMessageSendListener
    {
        public void onMessageSend(String message);
    }
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        btn = view.findViewById(R.id.button);
        editText = view.findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                onMessageSendListener.onMessageSend(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try
        {
            onMessageSendListener = (OnMessageSendListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " Must implement OnMessageSend");
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}
