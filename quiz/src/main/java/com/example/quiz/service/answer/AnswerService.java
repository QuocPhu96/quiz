package com.example.quiz.service.answer;

import com.example.quiz.model.Answer;
import com.example.quiz.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }
}
