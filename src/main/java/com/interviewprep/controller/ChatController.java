package com.interviewprep.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interviewprep.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/ask")
    public Map<String, String> askChatbot(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        String reply = chatService.askAI(message);

        return Map.of("reply", reply);
    }
}
