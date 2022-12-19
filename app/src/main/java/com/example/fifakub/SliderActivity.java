package com.example.fifakub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class SliderActivity extends AppCompatActivity {

    public ViewPager2 pager;
    List<SliderItems> dataList;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);

        pager = findViewById(R.id.pager);
        dataList = new ArrayList<>();
        dataList.add(new SliderItems(R.drawable.testttttt));
        dataList.add(new SliderItems(R.drawable.caicedo));
        dataList.add(new SliderItems(R.drawable.mane));
        dataList.add(new SliderItems(R.drawable.vandijk));
        dataList.add(new SliderItems(R.drawable.bale));
        dataList.add(new SliderItems(R.drawable.kane));
        dataList.add(new SliderItems(R.drawable.pulisic));
        dataList.add(new SliderItems(R.drawable.taremi));
        dataList.add(new SliderItems(R.drawable.al_dawsari));
        dataList.add(new SliderItems(R.drawable.jimenez));
        dataList.add(new SliderItems(R.drawable.lewandowski));
        dataList.add(new SliderItems(R.drawable.messi));
        dataList.add(new SliderItems(R.drawable.hrustic));
        dataList.add(new SliderItems(R.drawable.mbappe));
        dataList.add(new SliderItems(R.drawable.mejbri));
        dataList.add(new SliderItems(R.drawable.schmeichel));
        dataList.add(new SliderItems(R.drawable.kamada));
        dataList.add(new SliderItems(R.drawable.kimmich));
        dataList.add(new SliderItems(R.drawable.navas));
        dataList.add(new SliderItems(R.drawable.pedri));
        dataList.add(new SliderItems(R.drawable.davies));
        dataList.add(new SliderItems(R.drawable.de_bruyne));
        dataList.add(new SliderItems(R.drawable.hakimi));
        dataList.add(new SliderItems(R.drawable.modric));
        dataList.add(new SliderItems(R.drawable.anguissa));
        dataList.add(new SliderItems(R.drawable.mitrovic));
        dataList.add(new SliderItems(R.drawable.neymar));
        dataList.add(new SliderItems(R.drawable.xhaka));
        dataList.add(new SliderItems(R.drawable.nunez));
        dataList.add(new SliderItems(R.drawable.partey));
        dataList.add(new SliderItems(R.drawable.ronaldo));
        dataList.add(new SliderItems(R.drawable.son));




        myAdapter = new MyAdapter(dataList,this);
        pager.setAdapter(myAdapter);




    }
    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {
            SliderActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pager.getCurrentItem()< dataList.size()-1) {
                        pager.setCurrentItem(pager.getCurrentItem()+1);
                    }
                    else
                        pager.setCurrentItem(0);
                }
            });
        }
    }//close method


    public void btnBack(View v) {
        startActivity(new Intent(SliderActivity.this, MenuActivity.class));
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent menuform = new Intent(this, MenuActivity.class);
        startActivity(menuform);
        finish();
    }
}