package com.example.GreetingAPP.Controller;
import com.example.GreetingAPP.dto.AuthUserDTO;
import com.example.GreetingAPP.Service.AuthenticationService;
import com.example.GreetingAPP.Service.EmailService;
import com.example.GreetingAPP.dto.MailDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.GreetingAPP.dto.LoginDTO;

@RestController
public class AuthenticationController {
    EmailService emailService;
    AuthenticationService authenticationService;

    public AuthenticationController(EmailService emailService, AuthenticationService authenticationService) {
        this.emailService = emailService;
        this.authenticationService = authenticationService;
    }

//============================UC9(Register and Login for a User)==============================================//
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user){

        return authenticationService.register(user);
    }

    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){

        return authenticationService.login(user);
    }
//===========================UC10(Send Mail)===========================================//
    @PostMapping(path="/sendMail")
    public String sendMail(@RequestBody MailDTO user){ emailService.sendEmail(user.getTo(), user.getSubject(), user.getBody());
    return "Mail Sent";
    }





}