package com.example.mackanrishastv.question20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment2 extends Fragment {

    TextView textView2;

    public fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        textView2 = (TextView) view.findViewById(R.id.fragment2_textView);
        textView2.setText("Page 2/3");
        return view;
    }
}
