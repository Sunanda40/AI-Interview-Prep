package com.interviewprep.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.interviewprep.model.InterviewSession;

public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {
    List<InterviewSession> findByUserId(Long userId);
}