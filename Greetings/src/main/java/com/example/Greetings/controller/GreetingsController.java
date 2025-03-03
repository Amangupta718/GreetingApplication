package com.example.Greetings.controller;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    @Autowired
    private final GreetingService greetingService;
    //UC-2

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    //UC-3
    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, Mr./Ms. " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        return new Greeting(message);
    }
    //UC-4
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting.getMessage());
    }
    //UC-5 (Fetches the greeting message by ID)
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    //UC-6 (show all the Greeting messages in the repository)
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    //UC-7 (Update Greeting by ID)
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        return greetingService.updateGreeting(id, greeting.getMessage());
    }
    //UC-8 (Delete a Greeting message in the repository)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting deleted successfully!");
    }

    @PostMapping("/create")
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
