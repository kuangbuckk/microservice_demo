package jmaster.io.notificationservice.controller;

import jakarta.mail.Message;
import jmaster.io.notificationservice.model.MessageDTO;
import jmaster.io.notificationservice.service.EmailService;
import jmaster.io.notificationservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public void sendNotification(@RequestBody MessageDTO messageDTO){
        emailService.sendEmail(messageDTO);
    }
}
