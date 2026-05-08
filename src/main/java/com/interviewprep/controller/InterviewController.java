package com.interviewprep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interviewprep.model.InterviewAnswer;
import com.interviewprep.model.InterviewSession;
import com.interviewprep.model.Question;
import com.interviewprep.service.InterviewService;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin("*")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/start")
    public InterviewSession startInterview(
            @RequestParam Long userId,
            @RequestParam String interviewType) {
        return interviewService.startInterview(userId, interviewType);
    }

    @GetMapping("/questions/{category}")
    public List<Question> getQuestions(@PathVariable String category) {
        return interviewService.getInterviewQuestions(category);
    }

    @PostMapping("/answer")
    public InterviewAnswer submitAnswer(@RequestBody InterviewAnswer answer) {
        return interviewService.submitAnswer(answer);
    }

    @PostMapping("/end/{sessionId}")
    public InterviewSession endInterview(@PathVariable Long sessionId) {
        return interviewService.endInterview(sessionId);
    }

    @GetMapping("/history/{userId}")
    public List<InterviewSession> getHistory(@PathVariable Long userId) {
        return interviewService.getUserHistory(userId);
    }
}