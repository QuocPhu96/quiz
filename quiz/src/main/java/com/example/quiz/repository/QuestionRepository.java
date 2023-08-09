package com.example.quiz.repository;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findById(long id);
    List<Question> findQuestionsByQuiz(Quiz quiz);
}
