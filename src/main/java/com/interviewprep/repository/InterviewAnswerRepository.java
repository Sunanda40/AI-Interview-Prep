package com.interviewprep.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.interviewprep.model.InterviewAnswer;

public interface InterviewAnswerRepository extends JpaRepository<InterviewAnswer, Long> {
    List<InterviewAnswer> findBySessionId(Long sessionId);
    List<InterviewAnswer> findByUserId(Long userId);
}