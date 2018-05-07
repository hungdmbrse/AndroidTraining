package com.example.mackanrishastv.question20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class fragment1 extends Fragment {

    private String title;
    private int page;

    public static fragment1 newInstance(String title, int page) {

        fragment1 fragment1 = new fragment1();
        Bundle args = new Bundle();

        args.putString("someTitle", title);
        args.putInt("someInt", page);

        fragment1.setArguments(args);
        return fragment1;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = getArguments().getString("someTitle");
        page = getArguments().getInt("someInt", 0);
    }

    public fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        TextView txtViewPages = (TextView) view.findViewById(R.id.fragment1_textView);
        txtViewPages.setText("Page : " + page + "/3");

        return view;
    }
}
