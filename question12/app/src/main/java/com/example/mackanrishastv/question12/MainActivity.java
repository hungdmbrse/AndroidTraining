package com.example.mackanrishastv.question12;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText addressBar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!DetectConnection.checkInternetConnection(this)) {
            Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
        } else {
            webView = (WebView) findViewById(R.id.myWebView);
            CustomWebViewClient c = new CustomWebViewClient();
            webView.setWebViewClient(c);
            CreateWebView();
        }


        // Function to load all URLs in same webview


    }

    public void CreateWebView(){
        webView.clearCache(true);
        webView.clearHistory();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://www.google.com");
    }

    private class CustomWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!DetectConnection.checkInternetConnection(MainActivity.this)) {
                Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            } else {
                view.loadUrl(url);
            }
            return true;
        }
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
                if (!DetectConnection.checkInternetConnection(MainActivity.this)) {
                    Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
                } else {
                    if(webView != null){
                        webView.reload();
                    }
                    else {
                        CreateWebView();
                    }

                }

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
        if(webView.canGoBack()) {
            webView.goBack();
        }
    }

}
