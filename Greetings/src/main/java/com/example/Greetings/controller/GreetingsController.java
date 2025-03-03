package com.example.Greetings.controller;

import com.example.Greetings.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    @GetMapping
    public Greetingr getGreetings(){
        return new Greeting("Hello , My name is aman Gupta !");
    }
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting newGreeting){
        return new Greeting("Greeting Created :"+newGreeting.getMessage());
    }
    @PutMapping
    public Greeting updateGreeting(@RequestBody Greeting updatedGreeting){
        return new Greeting("Greetings Updated :"+updatedGreeting.getMessage());
    }
    @DeleteMapping
    public Greeting deleteGreeting(){
        return new Greeting("Greeting Deleted ");
    }
}
