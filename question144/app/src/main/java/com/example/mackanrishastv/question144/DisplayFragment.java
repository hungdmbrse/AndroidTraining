package com.example.mackanrishastv.question144;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment {

    private TextView textView;

    public DisplayFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_display, container, false);

        textView = view.findViewById(R.id.txt_message_display);
        return view;
    }

    public void changeText(){
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        textView.setText(message);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
