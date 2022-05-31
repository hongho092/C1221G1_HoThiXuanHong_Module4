package com.hohong.service.impl;

import com.hohong.dto.DonHangDto;
import com.hohong.model.DonHang;
import com.hohong.repository.IDonHangRepository;
import com.hohong.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService implements IDonHangService {

    @Autowired
    private IDonHangRepository donHangRepository;

    @Override
    public Page<DonHang> findAll(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }

    @Override
    public Page<DonHang> findAllSearchDay(String startDay, String endDay, Pageable pageable) {

        return donHangRepository.findAllSearchDay(startDay, endDay, pageable);
    }

    @Override
    public Page<DonHang> findAllByTop(Pageable pageable) {
        return donHangRepository.findAllTop(pageable);
    }

}
