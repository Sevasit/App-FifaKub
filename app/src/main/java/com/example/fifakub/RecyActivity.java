package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class RecyActivity extends AppCompatActivity {

    RecyclerView recycler_word;

    String s1[], s2[];

    int image[] = {R.drawable.na, R.drawable.nb, R.drawable.nc, R.drawable.nd,R.drawable.nf,R.drawable.ng,R.drawable.nh,R.drawable.yellow,R.drawable.red,R.drawable.cards,R.drawable.international,R.drawable.shootout,R.drawable.goalposts,R.drawable.shoot,R.drawable.cup,R.drawable.saves,R.drawable.handball,R.drawable.possession,R.drawable.foul,R.drawable.supporters,};

    int sound[] = {R.raw.qatar, R.raw.team, R.raw.al, R.raw.dark, R.raw.field, R.raw.music, R.raw.schedule, R.raw.yellow, R.raw.red, R.raw.cards, R.raw.international, R.raw.shootout, R.raw.goalposts, R.raw.shoot, R.raw.cup, R.raw.goalkeeper, R.raw.handball, R.raw.possession, R.raw.foul, R.raw.supporters};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);

        recycler_word = findViewById(R.id.recycler_word);

        s1 = getResources().getStringArray(R.array.fifa_word);
        s2 = getResources().getStringArray(R.array.description);

        WordAdapter wordAdapter = new WordAdapter(this, s1, s2, image, sound);
        recycler_word.setAdapter(wordAdapter);
        recycler_word.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent menuform = new Intent(this, MenuActivity.class);
        startActivity(menuform);
        finish();
    }

}