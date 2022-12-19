package com.example.fifakub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public MediaPlayer RunSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RunSound = MediaPlayer.create(MenuActivity.this, R.raw.levelup);
    }
    public void btnExit (View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        RunSound.start();
        builder.setMessage("คุณจะออกจากโปรเเกรมใช่หรือไม่?");
        builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),
                        "ขอบคุณที่ไว้วางใจ Fifakub", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        builder.show();
    }
    public void btnWeb (View view) {
        RunSound.start();
        Intent btnWeb = new Intent(this, WebActivity.class);
        startActivity(btnWeb);
        finish();
    }

    public void btnquiz (View view) {
        RunSound.start();
        Intent btnquiz = new Intent(this, QaActivity.class);
        startActivity(btnquiz);
        finish();
    }

    public void btncredit (View view) {
        RunSound.start();
        Intent btncredit = new Intent(this, CreditActivity.class);
        startActivity(btncredit);
        finish();
    }

    public void btnpictures (View view) {
        RunSound.start();
        Intent btnpictures = new Intent(this, SliderActivity.class);
        startActivity(btnpictures);
        finish();
    }

    public void btnword (View view) {
        RunSound.start();
        Intent btnword = new Intent(this, RecyActivity.class);
        startActivity(btnword);
        finish();
    }

    public void btnmail (View view) {
        RunSound.start();
        Intent btnmail = new Intent(this, MailActivity.class);
        startActivity(btnmail);
        finish();
    }
    /*
    public void btnpeople (View view) {
        Intent btnpeople = new Intent(this, .class);
        startActivity(btnpeople);
        finish();
    }
     */
}