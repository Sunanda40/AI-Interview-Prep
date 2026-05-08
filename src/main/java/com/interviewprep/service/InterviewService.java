package com.interviewprep.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewprep.model.InterviewAnswer;
import com.interviewprep.model.InterviewSession;
import com.interviewprep.model.Question;
import com.interviewprep.repository.InterviewAnswerRepository;
import com.interviewprep.repository.InterviewSessionRepository;
import com.interviewprep.repository.QuestionRepository;

@Service
public class InterviewService {

    @Autowired
    private InterviewSessionRepository sessionRepository;

    @Autowired
    private InterviewAnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AIService aiService;

    public InterviewSession startInterview(Long userId, String interviewType) {
        InterviewSession session = new InterviewSession();
        session.setUserId(userId);
        session.setInterviewType(interviewType);
        session.setStartTime(LocalDateTime.now());
        session.setStatus("STARTED");
        session.setTotalScore(0);

        return sessionRepository.save(session);
    }

    public List<Question> getInterviewQuestions(String category) {
        return questionRepository.findByCategory(category);
    }

    public InterviewAnswer submitAnswer(InterviewAnswer answer) {

        Question question = questionRepository.findById(answer.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        String aiResponse = aiService.getFeedback(
                question.getQuestionText(),
                answer.getUserAnswer()
        );

        answer.setAiFeedback(aiResponse);
        answer.setScore(extractScore(aiResponse));

        return answerRepository.save(answer);
    }

    private int extractScore(String aiResponse) {
        try {
            String[] lines = aiResponse.split("\\n");

            for (String line : lines) {
                if (line.toLowerCase().startsWith("score")) {
                    String number = line.replaceAll("[^0-9]", "");
                    return Integer.parseInt(number);
                }
            }
        } catch (Exception e) {
            return 0;
        }

        return 0;
    }

    public InterviewSession endInterview(Long sessionId) {
        InterviewSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setEndTime(LocalDateTime.now());
        session.setStatus("COMPLETED");

        return sessionRepository.save(session);
    }

    public List<InterviewSession> getUserHistory(Long userId) {
        return sessionRepository.findByUserId(userId);
    }
}