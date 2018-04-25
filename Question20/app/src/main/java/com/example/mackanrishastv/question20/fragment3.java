package com.example.mackanrishastv.question20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment3 extends Fragment {

    TextView textView3;

    public fragment3() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        textView3 = (TextView) view.findViewById(R.id.fragment3_textView);
        textView3.setText("Page 3/3");
        return view;
    }
}
