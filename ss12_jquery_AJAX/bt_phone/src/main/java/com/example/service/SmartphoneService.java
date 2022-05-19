package com.example.service;

import com.example.model.Smartphone;
import com.example.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

//    @Override
////    public void remove(Long id) {
////        smartPhoneRepository.deleteById(id);
////    }

    @Override
    public List<Smartphone> findAllSmarts() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Smartphone findById(int id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }
}
