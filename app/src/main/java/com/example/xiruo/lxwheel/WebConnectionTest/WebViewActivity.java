package com.example.xiruo.lxwheel.WebConnectionTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.example.xiruo.lxwheel.R;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    Button openWebBtn;
    EditText edit;
    String url  = "www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        openWebBtn = (Button) findViewById(R.id.btn1);
        edit = (EditText) findViewById(R.id.editText1);
        webView = (WebView) findViewById(R.id.webView1);
        WebSettings settings = webView .getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://" + url);

        openWebBtn.setOnClickListener(new WebViewActivity.mClick());

    }

    class mClick implements View.OnClickListener {
        public void onClick(View arg0) {

//            edit.getText().toString();
            webView.loadUrl("http://" + url);
        }
    }
}
