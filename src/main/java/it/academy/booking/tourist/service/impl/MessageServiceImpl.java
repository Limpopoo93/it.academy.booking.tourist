package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.model.Message;
import it.academy.booking.tourist.repository.MessageRepository;
import it.academy.booking.tourist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    @Transactional
    public Message saveAndFlush(Message message) {
        return messageRepository.saveAndFlush(message);
    }

}
