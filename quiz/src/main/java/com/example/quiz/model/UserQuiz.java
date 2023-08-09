package com.example.quiz.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class UserQuiz {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    private int numCorrect;
    private int totalQuestion;

    private String timeQuiz;
    private double score;
    public UserQuiz(){}

    public UserQuiz(long id, Users users, Quiz quiz, int numCorrect, int totalQuestion, String timeQuiz, double score) {
        this.id = id;
        this.users = users;
        this.quiz = quiz;
        this.numCorrect = numCorrect;
        this.totalQuestion = totalQuestion;
        this.timeQuiz = timeQuiz;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        this.numCorrect = numCorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public String getTimeQuiz() {
        return timeQuiz;
    }

    public void setTimeQuiz(String timeQuiz) {
        this.timeQuiz = timeQuiz;
    }
}
