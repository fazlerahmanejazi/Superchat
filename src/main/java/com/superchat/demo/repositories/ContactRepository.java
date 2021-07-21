package com.superchat.demo.repositories;

import com.superchat.demo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository
        extends JpaRepository<Contact, Long> {

    boolean existsContactByEmail(String email);



}
