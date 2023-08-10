package com.example.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String type;
    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private Set<QuizAnswer> quizAnswers;

}
