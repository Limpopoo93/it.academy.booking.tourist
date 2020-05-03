package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.PhotoRepository;
import it.academy.booking.tourist.request.Photo;
import it.academy.booking.tourist.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    @Transactional
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
    @Override
    public Optional<Photo> findById(Long id) {
        return photoRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Photo photo) {
        photoRepository.delete(photo);
    }
    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }
    @Override
    @Transactional
    public Photo saveAndFlush(Photo photo) {
        return photoRepository.saveAndFlush(photo);
    }
}
