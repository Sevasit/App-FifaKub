package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    public WebView webEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webEx = (WebView)findViewById(R.id.webShow);
        webEx.getSettings().setJavaScriptEnabled(true);
        webEx.loadUrl("https://www.mykhel.com/football/fifa-world-cup-2022-fixtures-l4/");
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent Data = new Intent(this, MenuActivity.class);
        startActivity(Data);
        finish();
    }
}