package com.example.mackanrishastv.question11;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText1 = (EditText) findViewById(R.id.editText);
        relativeLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        editText1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d("onEditorAction", "actionId = " + actionId + " event = " + (event == null ? "null" : event));
                if(event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if(event.getAction() == KeyEvent.ACTION_UP) {
                        Log.d("onEditorAction", "check");
                        // ソフトキーボードを隠す
                        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
                        Toast.makeText(getApplicationContext(), "editText1", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });



//        EditText editText2 = (EditText) findViewById(R.id.editText2);
//        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                // TODO Auto-generated method stub
//                Log.d("onEditorAction", "actionId = " + actionId + " event = " + (event == null ? "null" : event));
//                if(actionId == EditorInfo.IME_ACTION_DONE) {
//                    Log.d("onEditorAction", "check");
//                    // ソフトキーボードを隠す
//                    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
//                    Toast.makeText(getApplicationContext(), "editText2", Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//                return false;
//            }
//        });

//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//        mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        inputMethodManager.hideSoftInputFromWindow(relativeLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        relativeLayout.requestFocus();
        return false;
    }
}
