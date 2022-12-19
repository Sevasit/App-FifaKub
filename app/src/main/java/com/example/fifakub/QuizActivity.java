package com.example.fifakub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView quiz;
    private TextView score;

    private AppCompatButton optional1, optional2, optional3, optional4;
    private AppCompatButton btnNext;

    private Timer quizTimer;

    private int totalTimeMin = 2;

    private int seconds = 0;

    private List<QuestionList> questionLists = new ArrayList<>();

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    //Sound
    public MediaPlayer RunSound1, RunSound2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);


        final TextView time = findViewById(R.id.time);
        //score and quiz
        quiz = findViewById(R.id.quiz);
        score = findViewById(R.id.score);
        //คำตอบ
        optional1 = findViewById(R.id.optionl1);
        optional2 = findViewById(R.id.optionl2);
        optional3 = findViewById(R.id.optionl3);
        optional4 = findViewById(R.id.optionl4);
        //ปุ่มต่อไป
        btnNext = findViewById(R.id.btnNext);

        questionLists = QuestionBank.getQuestions();

        RunSound1 = MediaPlayer.create(QuizActivity.this, R.raw.wow);
        RunSound2 = MediaPlayer.create(QuizActivity.this, R.raw.fail);




        score.setText((currentQuestionPosition+1)+"/"+questionLists.size());
        quiz.setText(questionLists.get(0).getQuestion());
        optional1.setText(questionLists.get(0).getOptional1());
        optional2.setText(questionLists.get(0).getOptional2());
        optional3.setText(questionLists.get(0).getOptional3());
        optional4.setText(questionLists.get(0).getOptional4());


        optional1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = optional1.getText().toString();

                    optional1.setBackgroundResource(R.drawable.round_back_red);
                    optional1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        optional2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = optional2.getText().toString();

                    optional2.setBackgroundResource(R.drawable.round_back_red);
                    optional2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        optional3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = optional3.getText().toString();

                    optional3.setBackgroundResource(R.drawable.round_back_red);
                    optional3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        optional4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = optional4.getText().toString();

                    optional4.setBackgroundResource(R.drawable.round_back_red);
                    optional4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "โปรดเลือกคำตอบ!",Toast.LENGTH_SHORT).show();
                }else{
                    changeNextQuestion();
                }
            }
        });
        //**********************************************************
        startTimer(time);
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionLists.size()){
            btnNext.setText("ส่งคำตอบ");
            quizTimer.purge();
            quizTimer.cancel();
        }

        if(currentQuestionPosition < questionLists.size()){
            selectedOptionByUser = "";

            optional1.setBackgroundResource(R.drawable.round_back_light_green);
            optional1.setTextColor(Color.WHITE);

            optional2.setBackgroundResource(R.drawable.round_back_light_green);
            optional2.setTextColor(Color.WHITE);

            optional3.setBackgroundResource(R.drawable.round_back_light_green);
            optional3.setTextColor(Color.WHITE);

            optional4.setBackgroundResource(R.drawable.round_back_light_green);
            optional4.setTextColor(Color.WHITE);


            score.setText((currentQuestionPosition+1)+"/"+questionLists.size());
            quiz.setText(questionLists.get(currentQuestionPosition).getQuestion());
            optional1.setText(questionLists.get(currentQuestionPosition).getOptional1());
            optional2.setText(questionLists.get(currentQuestionPosition).getOptional2());
            optional3.setText(questionLists.get(currentQuestionPosition).getOptional3());
            optional4.setText(questionLists.get(currentQuestionPosition).getOptional4());
        }else{
            Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
            RunSound1.start();
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            startActivity(intent);
            finish();
        }

    }

    private void startTimer(TextView timerTextView) {

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0){
                    totalTimeMin--;
                    seconds = 59;

                }else if(seconds == 1 && totalTimeMin == 0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
                    RunSound2.start();
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(intent);
                    finish();

                }else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        String finalMinutes = String.valueOf(totalTimeMin);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }

                        if(finalSeconds.length() == 1){
                            finalSeconds = "0"+finalSeconds;
                        }
                        timerTextView.setText(finalMinutes + ":" + finalSeconds);
                    }
                });

            }
        }, 1000, 1000);
    }



    private int getCorrectAnswers() {

        int correctAnswer = 0;

        for(int i=0;i<questionLists.size();i++){
            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }

    private int getIncorrectAnswers() {

        int correctAnswer = 0;

        for(int i=0;i<questionLists.size();i++){
            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }

    private void revealAnswer(){
        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        if(optional1.getText().toString().equals(getAnswer)){
            optional1.setBackgroundResource(R.drawable.round_back_green);
            optional1.setTextColor(Color.WHITE);
        }else if(optional2.getText().toString().equals(getAnswer)){
            optional2.setBackgroundResource(R.drawable.round_back_green);
            optional2.setTextColor(Color.WHITE);
        }else if(optional3.getText().toString().equals(getAnswer)){
            optional3.setBackgroundResource(R.drawable.round_back_green);
            optional3.setTextColor(Color.WHITE);
        }else if(optional4.getText().toString().equals(getAnswer)){
            optional4.setBackgroundResource(R.drawable.round_back_green);
            optional4.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MenuActivity.class));
        finish();
    }
}