package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuiz);
        final TextView correctAnswer = findViewById(R.id.CorrectAnswer);
        final TextView incorrectAnswer = findViewById(R.id.WrongAnswer);

        final int getCorrectAnswer = getIntent().getIntExtra("correct", 0);
        final int getInCorrectAnswer = getIntent().getIntExtra("incorrect", 0);

        correctAnswer.setText("คำตอบที่ถูกต้อง : " + String.valueOf(getCorrectAnswer) + " ข้อ");
        incorrectAnswer.setText("คำตอบที่ผิด : " + String.valueOf(getInCorrectAnswer) + " ข้อ");

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResultActivity.this, MenuActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResultActivity.this, MenuActivity.class));
        finish();
    }
}