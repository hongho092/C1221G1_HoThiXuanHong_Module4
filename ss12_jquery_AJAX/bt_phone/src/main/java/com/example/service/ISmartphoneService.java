package com.example.service;

import com.example.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone save(Smartphone smartPhone);

    void remove(int id);

    List<Smartphone> findAllSmarts();

    Smartphone findById(int id);
}
