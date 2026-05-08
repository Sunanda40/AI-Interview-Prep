package com.interviewprep.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewprep.model.InterviewAnswer;
import com.interviewprep.model.InterviewSession;
import com.interviewprep.repository.InterviewAnswerRepository;
import com.interviewprep.repository.InterviewSessionRepository;

@Service
public class DashboardService {

    @Autowired
    private InterviewSessionRepository sessionRepository;

    @Autowired
    private InterviewAnswerRepository answerRepository;

    public Map<String, Object> getUserDashboard(Long userId) {

        List<InterviewSession> sessions = sessionRepository.findByUserId(userId);
        List<InterviewAnswer> answers = answerRepository.findByUserId(userId);

        int totalInterviews = sessions.size();
        int totalAnswers = answers.size();

        double averageScore = 0;

        if (!answers.isEmpty()) {
            int totalScore = 0;

            for (InterviewAnswer answer : answers) {
                if (answer.getScore() != null) {
                    totalScore += answer.getScore();
                }
            }

            averageScore = (double) totalScore / answers.size();
        }

        String latestFeedback = "No feedback available";

        if (!answers.isEmpty()) {
            latestFeedback = answers.get(answers.size() - 1).getAiFeedback();
        }

        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("userId", userId);
        dashboard.put("totalInterviews", totalInterviews);
        dashboard.put("totalAnswers", totalAnswers);
        dashboard.put("averageScore", averageScore);
        dashboard.put("latestFeedback", latestFeedback);

        return dashboard;
    }
}
