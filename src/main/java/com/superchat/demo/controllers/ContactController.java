package com.superchat.demo.controllers;

import com.superchat.demo.models.Contact;
import com.superchat.demo.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {


    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @PostMapping("/create")
    public long createContact(@RequestBody Contact contact) {
        long contactId = contactService.create(contact);
        return contactId;
    }

    @GetMapping("/list")
    public List<Contact> listContacts() {
        return contactService.retrieve();
    }

}
