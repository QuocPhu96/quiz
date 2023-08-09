package com.example.quiz.controller.rest;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.service.question.QuestionService;
import com.example.quiz.service.quiz.QuizService;
import com.example.quiz.service.response.QuestionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllQuestionByIdQuiz(@RequestParam long id) {
        Quiz quiz = quizService.findById(id);
        List<Question> questions = questionService.findAllQuestionByIdQuiz(quiz);
        List<QuestionResponseDTO> questionResponseDTOS = new ArrayList<>();
        for (Question question : questions ) {
            QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
            questionResponseDTO.setId(question.getId());
            questionResponseDTO.setAnswers(question.getAnswers());
            questionResponseDTO.setTitle(question.getTitle());
            questionResponseDTOS.add(questionResponseDTO);
        }
        return ResponseEntity.ok(questionResponseDTOS);
    }
}
