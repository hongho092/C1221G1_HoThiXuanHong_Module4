package com.hohong.service.impl;

import com.hohong.model.KhachHang;
import com.hohong.repository.IKhachHangRepository;
import com.hohong.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
}
