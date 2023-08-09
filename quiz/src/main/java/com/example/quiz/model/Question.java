package com.example.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private Set<Answer> answers;
    private String title;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;
    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private Set<QuizAnswer> quizAnswers;
    public Question(){}

    public Question(long id, Set<Answer> answers, String title, Quiz quiz, Set<QuizAnswer> quizAnswers) {
        this.id = id;
        this.answers = answers;
        this.title = title;
        this.quiz = quiz;
        this.quizAnswers = quizAnswers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<QuizAnswer> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(Set<QuizAnswer> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
}
