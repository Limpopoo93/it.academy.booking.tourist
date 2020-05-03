package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    Photo save(Photo photo);

    Optional<Photo> findById(Long id);

    void delete(Photo photo);

    List<Photo> findAll();

    Photo saveAndFlush(Photo photo);
}
