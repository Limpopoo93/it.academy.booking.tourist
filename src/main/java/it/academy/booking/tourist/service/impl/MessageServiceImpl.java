package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.MessageRepository;
import it.academy.booking.tourist.request.Message;
import it.academy.booking.tourist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Optional<Message> findById(Long id){
        return messageRepository.findById(id);
    }

    public void delete(Message message){
        messageRepository.delete(message);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message saveAndFlush(Message message){
        return messageRepository.saveAndFlush(message);
    }
}
