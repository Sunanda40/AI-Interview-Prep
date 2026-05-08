package com.interviewprep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewprep.model.Question;
import com.interviewprep.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(@PathVariable String category) {
        return questionService.getByCategory(category);
    }

    @GetMapping("/topic/{topic}")
    public List<Question> getByTopic(@PathVariable String topic) {
        return questionService.getByTopic(topic);
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<Question> getByDifficulty(@PathVariable String difficulty) {
        return questionService.getByDifficulty(difficulty);
    }
}
