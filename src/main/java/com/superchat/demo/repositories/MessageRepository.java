package com.superchat.demo.repositories;

import com.superchat.demo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllBySenderId(Long senderId);
    List<Message> findAllByRecieverId(Long recieverId);
    List<Message> findAllBySenderIdAndRecieverId(Long senderId, Long recieverId);

}
