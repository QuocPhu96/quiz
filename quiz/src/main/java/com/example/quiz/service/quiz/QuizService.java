package com.example.quiz.service.quiz;

import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<Quiz> findAll(){
        return quizRepository.findAll();
    }

    public Quiz findById(long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.get();
    }
}
