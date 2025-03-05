package com.example.GreetingAPP.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id  // Add this annotation to mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate values for this field
    private Long id;

    public  String message;

    public Greeting(){}

    // Constructor
    public Greeting(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
