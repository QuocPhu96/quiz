package com.example.quiz.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String email;
    @OneToMany(mappedBy = "users")
    private Set<UserQuiz> userQuizs;
    @OneToMany(mappedBy = "users")
    private Set<QuizAnswer> quizAnswers;
    public Users(){}

    public Users(long id, String userName, String password, String email, Set<UserQuiz> userQuizs, Set<QuizAnswer> quizAnswers) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userQuizs = userQuizs;
        this.quizAnswers = quizAnswers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Set<UserQuiz> getUserQuizs() {
        return userQuizs;
    }

    public void setUserQuizs(Set<UserQuiz> userQuizs) {
        this.userQuizs = userQuizs;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<QuizAnswer> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(Set<QuizAnswer> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
}
