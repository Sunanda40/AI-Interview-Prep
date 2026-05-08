package com.interviewprep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;   // HR, TECHNICAL, CODING
    private String topic;      // Java, OOPs, SQL, DSA
    private String difficulty; // EASY, MEDIUM, HARD

    @Column(length = 2000)
    private String questionText;

    @Column(length = 3000)
    private String modelAnswer;

    public Question() {
    }
    

	public Question(Long id, String category, String topic, String difficulty, String questionText,
			String modelAnswer) {
		super();
		this.id = id;
		this.category = category;
		this.topic = topic;
		this.difficulty = difficulty;
		this.questionText = questionText;
		this.modelAnswer = modelAnswer;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getModelAnswer() {
		return modelAnswer;
	}

	public void setModelAnswer(String modelAnswer) {
		this.modelAnswer = modelAnswer;
	}
    

}
