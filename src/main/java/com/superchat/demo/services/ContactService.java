package com.superchat.demo.services;

import com.superchat.demo.models.Contact;
import com.superchat.demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public long create(Contact contact) {
        Boolean existsEmail = contactRepository.existsContactByEmail(contact.getEmail());

        if (existsEmail) {
            throw new RuntimeException(
                    "Email " + contact.getEmail() + " taken.");
        }
        contactRepository.save(contact);
        return contact.getUserId();
    }

    public List<Contact> retrieve() {
        return contactRepository.findAll();
    }
}
