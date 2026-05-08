package com.interviewprep.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "interview_sessions")
public class InterviewSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String interviewType; // HR, TECHNICAL, CODING
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer totalScore;
    private String status; // STARTED, COMPLETED

    public InterviewSession() {
    }

	public InterviewSession(Long id, Long userId, String interviewType, LocalDateTime startTime, LocalDateTime endTime,
			Integer totalScore, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.interviewType = interviewType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalScore = totalScore;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
