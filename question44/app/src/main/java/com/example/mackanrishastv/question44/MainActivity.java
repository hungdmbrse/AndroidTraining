package com.example.mackanrishastv.question44;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TextView txtViewAcc, txtViewId, txtViewBalance;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this.getApplicationContext();
        mPrefs = context.getSharedPreferences("myAppPrefs", 0);

        if (getFirstRun()){
            final SharedPreferences sharedPreferences = getSharedPreferences("userInfor", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", "田中木村");
            editor.putInt("acc", 232456234);
            editor.putFloat("balance", (float) 236432.534);
            editor.apply();

            setRunned();

        }

        AnhXa();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfor", Context.MODE_PRIVATE);

                String name = sharedPreferences.getString("name", "");
                int id = sharedPreferences.getInt("acc", 0);
                double balance = sharedPreferences.getFloat("balance", 0);

                txtViewAcc.setText(name);
                txtViewId.setText(String.valueOf(id));
                txtViewBalance.setText(String.valueOf(balance) + "¥");

            }
        });
    }

    public void AnhXa(){

        btnShow =(Button) findViewById(R.id.btnShowInfor);
        txtViewAcc = (TextView) findViewById(R.id.txtViewAcc);
        txtViewId = (TextView) findViewById(R.id.txtViewId);
        txtViewBalance = (TextView) findViewById(R.id.txtViewBalance);
    }

    public boolean getFirstRun(){
        return mPrefs.getBoolean("firstRun", true);
    }

    public void setRunned(){
        SharedPreferences.Editor edit = mPrefs.edit();
        edit.putBoolean("firstRun", false);
        edit.commit();
    }
}
