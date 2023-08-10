package com.example.quiz.service.response;

import com.example.quiz.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {
    private long id;
    private String title;
    private String type;
    private Set<Answer> answers;

}
