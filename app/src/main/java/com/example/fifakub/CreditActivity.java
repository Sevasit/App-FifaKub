package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class CreditActivity extends AppCompatActivity {

    public ViewPager2 pagerpp;
    List<SliderItems> dataListpp;
    MyAdapterpp MyAdapterpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new CreditActivity.The_slide_timer(),2000,3000);

        pagerpp = findViewById(R.id.pagerpp);
        dataListpp = new ArrayList<>();
        dataListpp.add(new SliderItems(R.drawable.pondzaza));
        dataListpp.add(new SliderItems(R.drawable.newzazaza));
        dataListpp.add(new SliderItems(R.drawable.winzaza));
        dataListpp.add(new SliderItems(R.drawable.folkzaza));
        dataListpp.add(new SliderItems(R.drawable.paizaza));
        dataListpp.add(new SliderItems(R.drawable.pluemzaza));
        dataListpp.add(new SliderItems(R.drawable.bowzaza));

        MyAdapterpp = new MyAdapterpp(dataListpp,this);
        pagerpp.setAdapter(MyAdapterpp);




    }
    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {
            CreditActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pagerpp.getCurrentItem()< dataListpp.size()-1) {
                        pagerpp.setCurrentItem(pagerpp.getCurrentItem()+1);
                    }
                    else
                        pagerpp.setCurrentItem(0);
                }
            });
        }
    }//close method


    public void btnBack(View v) {
        startActivity(new Intent(CreditActivity.this, MenuActivity.class));
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent menuform = new Intent(this, MenuActivity.class);
        startActivity(menuform);
        finish();
    }
}