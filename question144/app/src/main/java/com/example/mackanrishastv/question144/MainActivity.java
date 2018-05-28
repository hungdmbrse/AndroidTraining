package com.example.mackanrishastv.question144;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {


    private MessageFragment messageFragment;
    private DisplayFragment displayFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
        }

        messageFragment = new MessageFragment();
        displayFragment = new DisplayFragment();


        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment, null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, displayFragment, null).commit();

    }

    @Override
    public void onMessageSend(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        displayFragment.setArguments(bundle);
        displayFragment.changeText();

    }
}
