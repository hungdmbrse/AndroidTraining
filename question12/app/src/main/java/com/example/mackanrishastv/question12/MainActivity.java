package com.example.mackanrishastv.question12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText addressBar;
    private WebView webView;
    private Button btn_back;
    private Button btn_forward;
    private Button btn_reload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back = (Button) findViewById(R.id.buttonBack);
        btn_forward = (Button) findViewById(R.id.buttonForward);
        btn_reload = (Button) findViewById(R.id.buttonReload);

        webView = (WebView) findViewById(R.id.myWebView);
        webView.loadUrl("https://www.google.com");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        btn_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_forward.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                onForwardPressed();
            }
        });

        btn_reload.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.super_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_back:
                onBackPressed();
                break;
            case R.id.men_forward:
                onForwardPressed();
                break;
            case R.id.menu_refresh:
                webView.reload();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onForwardPressed(){
        if(webView.canGoForward()){
            webView.goForward();
        } else{
            Toast.makeText(this, "Can't go futher !" , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else{
            finish();
        }
    }
}
