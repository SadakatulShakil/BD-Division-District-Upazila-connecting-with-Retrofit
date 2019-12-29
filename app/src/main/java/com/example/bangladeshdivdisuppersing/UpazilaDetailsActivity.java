package com.example.bangladeshdivdisuppersing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.bangladeshdivdisuppersing.Model.UpazilaData;

public class UpazilaDetailsActivity extends AppCompatActivity {
    private WebView upWebPage;
    public UpazilaData upazila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upazila_details);

        Intent intent = getIntent();
        upazila = intent.getExtras().getParcelable("Upazila");

        upWebPage = findViewById(R.id.upWeb);
        upWebPage = new WebView(UpazilaDetailsActivity.this);
        setContentView(upWebPage);
        WebSettings webSettings = upWebPage.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String url = "http://"+upazila.getUrl();

        upWebPage.loadUrl(url);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.upWebPage.canGoBack()) {
            this.upWebPage.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
