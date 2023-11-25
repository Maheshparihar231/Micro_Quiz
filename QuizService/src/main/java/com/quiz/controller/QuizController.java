package com.quiz.controller;

import com.quiz.QuizServiceApplication;
import com.quiz.entity.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizServices;


    @GetMapping("/all")
    public List<Quiz> getAll(){
        return quizServices.get();
    }

    @PostMapping("/add")
    public Quiz saveQuiz(@RequestBody Quiz quiz){
        return quizServices.add(quiz);
    }

    @GetMapping("/find/{id}")
    public Quiz findQuiz(@PathVariable Long id){
        return quizServices.getById(id);
    }
}
