package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.PhotoRepository;
import it.academy.booking.tourist.request.Photo;
import it.academy.booking.tourist.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Photo save(Photo photo){
        return photoRepository.save(photo);
    }

    public Optional<Photo> findById(Long id){
        return photoRepository.findById(id);
    }

    public void delete(Photo photo){
        photoRepository.delete(photo);
    }

    public List<Photo> findAll(){
        return photoRepository.findAll();
    }

    public Photo saveAndFlush(Photo photo){
        return photoRepository.saveAndFlush(photo);
    }
}
