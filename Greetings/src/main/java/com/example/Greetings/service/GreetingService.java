package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreeting() {
        return new Greeting("Hello World");
    }
}
