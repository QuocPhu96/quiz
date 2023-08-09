package com.example.quiz.service.question;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public List<Question> findAllQuestionByIdQuiz(Quiz quiz) {
        return questionRepository.findQuestionsByQuiz(quiz);
    }
}
