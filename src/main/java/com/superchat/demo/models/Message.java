package com.superchat.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {

    @Id @GeneratedValue private long messageId;
    private long senderId;
    private long recieverId;
    private String messageBody;

    public Message() {

    }

    public Message(long messageId, long senderId, long recieverId, String messageBody) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.messageBody = messageBody;
    }

    public Message(Message message) {
        this.messageId = message.getMessageId();
        this.senderId = message.getSenderId();
        this.recieverId = message.getRecieverId();
        this.messageBody = message.getMessageBody();
    }

    public long getMessageId() {
        return messageId;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getRecieverId() {
        return recieverId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public void setRecieverId(long recieverId) {
        this.recieverId = recieverId;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
