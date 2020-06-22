package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Photo;

import java.util.List;

public interface PhotoService {
    Photo save(Photo photo);

    Photo findById(Long id);

    void delete(Photo photo);

    List<Photo> findAll();

    Photo saveAndFlush(Photo photo);

}
