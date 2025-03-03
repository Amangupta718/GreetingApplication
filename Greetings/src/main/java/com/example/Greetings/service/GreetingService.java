package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    //UC-4(saving messages with their id)
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
    //storing all messages in repo layer(UC-6)
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    //UC-5 (finding by id)
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }
}
