package com.example.mackanrishastv.question6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Employee proG1 = new Programmer("MHung", 23, true, "Mabashi", 20000, 1, 'C');
        Employee proG2 = new Programmer("AQuan", 25, true, "Gotanda", 23000, 2, 'A');
        Employee deS1 = new Designer("Alex", 25, false, "Akabane", 23000,2);
        Employee deS2 = new Designer("Amy", 24, false, "Ikebe", 24000, 3);

        proG1.computeYearlyPay();
        proG2.computeYearlyPay();
        deS1.computeYearlyPay();
        deS2.computeYearlyPay();

    }
}
