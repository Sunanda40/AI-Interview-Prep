package com.interviewprep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewprep.model.Question;
import com.interviewprep.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
    private QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> getByTopic(String topic) {
        return questionRepository.findByTopic(topic);
    }

    public List<Question> getByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

}
