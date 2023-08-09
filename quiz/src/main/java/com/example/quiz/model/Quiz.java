package com.example.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String quizName;
    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private Set<UserQuiz> userQuizs;
    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private Set<Question> questions;
    public Quiz(){}

    public Quiz(long id, String quizName, Set<UserQuiz> userQuizs, Set<Question> questions) {
        this.id = id;
        this.quizName = quizName;
        this.userQuizs = userQuizs;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Set<UserQuiz> getUserQuizs() {
        return userQuizs;
    }

    public void setUserQuizs(Set<UserQuiz> userQuizs) {
        this.userQuizs = userQuizs;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
