package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fifakub.databinding.ActivityMailBinding;

public class MailActivity extends AppCompatActivity {

    ActivityMailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        binding = ActivityMailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = binding.emailAddress.getText().toString();
                String subject = binding.subject.getText().toString();
                String message = binding.Message.getText().toString();

                String[] address = email.split(",");
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mail: to"));
                intent.putExtra(intent.EXTRA_EMAIL,address);
                intent.putExtra(intent.EXTRA_SUBJECT,subject);
                intent.putExtra(intent.EXTRA_TEXT,message);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MailActivity.this,"ไม่มี App email ที่ส่ง กรุณาตรวจสอบ",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    public void onBackPressed() {

        startActivity(new Intent(MailActivity.this, MenuActivity.class));
        finish();
    }
}