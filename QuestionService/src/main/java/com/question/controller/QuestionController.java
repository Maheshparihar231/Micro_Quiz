package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAll(){
        return questionService.get();
    }

    @PostMapping("/add")
    public Question add(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping("/find/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getByQuizId(@PathVariable Long id){
        return questionService.getQuestionOfQuiz(id);
    }
}
