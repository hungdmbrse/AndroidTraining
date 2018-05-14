package com.example.mackanrishastv.question5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FiveYearTeacher fiveYearTeacher1 = new FiveYearTeacher("DMHung", 23, true,20000);
        TenYearTeacher tenYearTeacher1 = new TenYearTeacher("LHHoa", 30, false, 30000);
        FiveYearTeacher fiveYearTeacher2 = new FiveYearTeacher("LVTra", 24, true, 23000);
        TenYearTeacher tenYearTeacher2 = new TenYearTeacher("DQToan", 31, true, 32000);

        Log.d("ManhHung5", "Hung of salary :" + String.valueOf(fiveYearTeacher1.calculateSalary()));
        Log.d("ManhHung5", "Hoa of salary :" + String.valueOf(tenYearTeacher1.calculateSalary()));
        Log.d("ManhHung5", "Tra of salary :" + String.valueOf(fiveYearTeacher2.calculateSalary()));
        Log.d("ManhHung5", "Toan of salary :" + String.valueOf(tenYearTeacher2.calculateSalary()));
    }
}
