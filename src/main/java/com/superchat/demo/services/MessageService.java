package com.superchat.demo.services;

import com.superchat.demo.controllers.MessageController;
import com.superchat.demo.models.Message;
import com.superchat.demo.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public long send(Message message) {
        messageRepository.save(message);
        return message.getMessageId();
    }

    public List<Message> retrieveConversation(long firstUserId, long secondUserId) {
        List<Message> messages = messageRepository.findAllBySenderIdAndRecieverId(firstUserId, secondUserId);
        messages.addAll(messageRepository.findAllBySenderIdAndRecieverId(secondUserId, firstUserId));
        return messages;
    }

    public List<Message> retrieveConversations(long userId) {
        List<Message> messages = messageRepository.findAllBySenderId(userId);
        messages.addAll(messageRepository.findAllByRecieverId(userId));
        return messages;
    }


}