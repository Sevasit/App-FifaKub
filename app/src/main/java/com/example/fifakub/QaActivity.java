package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
    }

    public void btnGo (View view) {
        Intent btnGo = new Intent(this, QuizActivity.class);
        startActivity(btnGo);
        finish();
    }
    public void btnGoMenu (View view) {
        Intent btnGoMenu = new Intent(this, MenuActivity.class);
        startActivity(btnGoMenu);
        finish();
    }
    public void onBackPressed() {
        startActivity(new Intent(QaActivity.this, MenuActivity.class));
        finish();
    }
}