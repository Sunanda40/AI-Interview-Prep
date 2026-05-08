package com.interviewprep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interviewprep.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    List<Question> findByTopic(String topic);

    List<Question> findByDifficulty(String difficulty);
}