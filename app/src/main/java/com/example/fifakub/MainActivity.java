package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fifakub.Models.FixtureResponse;
import com.example.fifakub.adapter.FixtureAdapter;
import com.example.fifakub.manager.RequestManager;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressDialog dialog;
    RequestManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_fixture);

        dialog = new ProgressDialog(this);
        dialog.setTitle("กำลังโหลด โปรดรอสักครู่...");

        manager = new RequestManager(this);
        manager.getFixture(listener, 1331);
        dialog.show();
    }

    private final ResponseListener listener = new ResponseListener() {
        @Override
        public void didFetch(FixtureResponse response, String message) {
            dialog.dismiss();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
            FixtureAdapter adapter = new FixtureAdapter(MainActivity.this, response.data);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };
    public void onBackPressed() {
        super.onBackPressed();
        Intent menuform = new Intent(this, MenuActivity.class);
        startActivity(menuform);
        finish();
    }
}