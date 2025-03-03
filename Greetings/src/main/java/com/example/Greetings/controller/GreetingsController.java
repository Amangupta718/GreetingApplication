package com.example.Greetings.controller;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    private final GreetingService greetingService;

    @Autowired
    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Greeting getGreetings() {
        return new Greeting("Hello, My name is Aman Gupta!");
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting newGreeting) {
        return new Greeting("Greeting Created: " + newGreeting.getMessage());
    }

    @PutMapping
    public Greeting updateGreeting(@RequestBody Greeting updatedGreeting) {
        return new Greeting("Greeting Updated: " + updatedGreeting.getMessage());
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Greeting Deleted");
    }
}
