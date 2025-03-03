package com.example.greeting.service;

import com.example.greeting.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreeting() {
        return new Greeting("Hello World");
    }
}
