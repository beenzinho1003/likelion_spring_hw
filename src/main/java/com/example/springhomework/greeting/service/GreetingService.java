package com.example.springhomework.greeting.service;

import com.example.springhomework.greeting.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final MessageRepository messageRepository;

    public GreetingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String greet(String name, int hour) {
        String result;

        if (hour >= 0 && hour <= 5) {
            result = "아직 안 주무셨어요?";
        } else {
            String greeting;

            if (hour < 12) {
                greeting = "좋은 아침이에요";
            } else if (hour < 18) {
                greeting = "좋은 오후예요";
            } else {
                greeting = "좋은 저녁이에요";
            }

            result = greeting + "," + name + "님!";
        }

        messageRepository.save(result);
        return result;
    }

    public int count() {
        return messageRepository.count();
    }
}