package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.PriceRepository;
import it.academy.booking.tourist.request.Price;
import it.academy.booking.tourist.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Price save(Price price){
        return priceRepository.save(price);
    }

    public Optional<Price> findById(Long id){
        return priceRepository.findById(id);
    }

    public void delete(Price price){
        priceRepository.delete(price);
    }

    public List<Price> findAll(){
        return priceRepository.findAll();
    }

    public Price saveAndFlush(Price price){
        return priceRepository.saveAndFlush(price);
    }
}
