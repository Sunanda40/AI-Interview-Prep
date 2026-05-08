package com.interviewprep.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class AIService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final String URL = "https://api.openai.com/v1/chat/completions";

    public String getFeedback(String question, String userAnswer) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini");

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");

        message.put("content",
                "Evaluate this interview answer and return ONLY in this format:\n" +
                "Score: <number out of 10>\n" +
                "Feedback: <short feedback>\n" +
                "MissingPoints: <missing points>\n\n" +
                "Question: " + question + "\n" +
                "User Answer: " + userAnswer
        );
        messages.add(message);
        body.put("messages", messages);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        Map response = restTemplate.postForObject(URL, request, Map.class);

        List choices = (List) response.get("choices");
        Map choice = (Map) choices.get(0);
        Map messageResponse = (Map) choice.get("message");

        return messageResponse.get("content").toString();
    }
}