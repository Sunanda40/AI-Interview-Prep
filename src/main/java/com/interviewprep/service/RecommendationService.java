package com.interviewprep.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewprep.model.InterviewAnswer;
import com.interviewprep.repository.InterviewAnswerRepository;

@Service
public class RecommendationService {

    @Autowired
    private InterviewAnswerRepository answerRepository;

    public Map<String, Object> getRecommendations(Long userId) {

        List<InterviewAnswer> answers = answerRepository.findByUserId(userId);

        Map<String, Object> response = new HashMap<>();

        if (answers.isEmpty()) {
            response.put("message", "No data available. Start an interview first.");
            return response;
        }

        int totalScore = 0;
        int count = 0;

        for (InterviewAnswer ans : answers) {
            if (ans.getScore() != null) {
                totalScore += ans.getScore();
                count++;
            }
        }

        double avg = (count == 0) ? 0 : (double) totalScore / count;

        String level;
        String suggestion;

        if (avg < 4) {
            level = "BEGINNER";
            suggestion = "Focus on basics. Practice easy questions.";
        } else if (avg < 7) {
            level = "INTERMEDIATE";
            suggestion = "You are improving. Practice more medium-level questions.";
        } else {
            level = "ADVANCED";
            suggestion = "Good performance. Try hard-level and real interview questions.";
        }

        response.put("averageScore", avg);
        response.put("level", level);
        response.put("suggestion", suggestion);

        return response;
    }
}
