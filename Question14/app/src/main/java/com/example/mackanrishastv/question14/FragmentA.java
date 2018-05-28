package com.example.mackanrishastv.question14;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {

    EditText edtA;
    Button btnA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        edtA = (EditText) view.findViewById(R.id.editTextA);
        btnA = (Button) view.findViewById(R.id.buttonA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtB = (TextView) getActivity().findViewById(R.id.textViewB);
                txtB.setText(edtA.getText().toString());
            }
        });

        return view;
    }
}
