package com.superchat.demo.controllers;

import com.superchat.demo.models.Message;
import com.superchat.demo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public long sendMessage(@RequestBody Message message) {
        long messageId = messageService.send(message);
        return messageId;
    }

    @GetMapping("list/{firstUserId}/{secondUserId}")
    public List<Message> listConversation(
            @PathVariable("firstUserId") long firstUserId,
            @PathVariable("secondUserId") long secondUserId) {
        return messageService.retrieveConversation(firstUserId, secondUserId);
    }

    @GetMapping("/list/{userId}")
    public List<Message> listConversations(@PathVariable("userId") long userId) {
        return messageService.retrieveConversations(userId);
    }

}
