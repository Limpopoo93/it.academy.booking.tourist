package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Message;

import java.util.List;

public interface MessageService {
    Message save(Message message);

    Message findById(Long id);

    void delete(Message message);

    List<Message> findAll();

    Message saveAndFlush(Message message);

    List<Message> findByDelete(Boolean delete);
}
