package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.PriceRepository;
import it.academy.booking.tourist.request.Price;
import it.academy.booking.tourist.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Override
    @Transactional
    public Price save(Price price) {
        return priceRepository.save(price);
    }
    @Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Price price) {
        priceRepository.delete(price);
    }
    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }
    @Override
    @Transactional
    public Price saveAndFlush(Price price) {
        return priceRepository.saveAndFlush(price);
    }
}
