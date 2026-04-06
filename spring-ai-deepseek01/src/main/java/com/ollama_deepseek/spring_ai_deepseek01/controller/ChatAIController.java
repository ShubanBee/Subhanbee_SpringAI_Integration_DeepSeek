package com.ollama_deepseek.spring_ai_deepseek01.controller;

import com.ollama_deepseek.spring_ai_deepseek01.service.ChatAIService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ai")
public class ChatAIController {
    @Autowired
    private ChatAIService chatAIService;

    @GetMapping("/prompt")
    public String askToAI(@RequestParam(value="question") String question){
        return chatAIService.askToDeepSeekAI(question);
    }

    @GetMapping("/prompt/stream")
    public Flux<String> askToAIWithStrtream(@RequestParam(value="question") String question){
        return chatAIService.askToDeepSeekAIWithStream(question);

    }
}
