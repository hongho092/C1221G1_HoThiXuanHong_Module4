package com.hohong.service.impl;

import com.hohong.model.LoaiGiaoDich;
import com.hohong.repository.ILoaiGiaoDichRepository;
import com.hohong.service.ILoaiGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiGiaoDichService implements ILoaiGiaoDichService {

    @Autowired
    private ILoaiGiaoDichRepository loaiGiaoDichRepository;

    @Override
    public List<LoaiGiaoDich> findAll() {
        return loaiGiaoDichRepository.findAll();
    }
}
