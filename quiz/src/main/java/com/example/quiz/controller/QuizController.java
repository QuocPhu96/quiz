package com.example.quiz.controller;

import com.example.quiz.model.Quiz;
import com.example.quiz.service.answer.AnswerService;
import com.example.quiz.service.question.QuestionService;
import com.example.quiz.service.quiz.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @GetMapping
    public ModelAndView showQuiz(){
        ModelAndView view = new ModelAndView();
        Quiz quiz = new Quiz();
        view.addObject("quiz", quiz);
        view.addObject("question", questionService.findAll());
        view.addObject("answer", answerService.findAll());
        return view;
    }
}
