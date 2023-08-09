package com.example.quiz.service.response;

import com.example.quiz.model.Answer;

import java.util.Set;

public class QuestionResponseDTO {
    private long id;
    private String title;
    private Set<Answer> answers;
    public QuestionResponseDTO(){}

    public QuestionResponseDTO(long id, String title, Set<Answer> answers) {
        this.id = id;
        this.title = title;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
