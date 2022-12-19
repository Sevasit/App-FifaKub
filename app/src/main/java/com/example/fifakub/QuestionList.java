package com.example.fifakub;

public class QuestionList {
    private  String question, optional1, optional2, optional3, optional4, answer;
    private  String userSelectedAnswer;

    public QuestionList(String question, String optional1, String optional2, String optional3, String optional4, String answer, String userSelectedAnswer) {
        this.question = question;
        this.optional1 = optional1;
        this.optional2 = optional2;
        this.optional3 = optional3;
        this.optional4 = optional4;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptional1() {
        return optional1;
    }

    public String getOptional2() {
        return optional2;
    }

    public String getOptional3() {
        return optional3;
    }

    public String getOptional4() {
        return optional4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
