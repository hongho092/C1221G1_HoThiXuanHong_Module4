package com.hohong.service;

import com.hohong.dto.DonHangDto;
import com.hohong.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDonHangService {
    Page<DonHang> findAll(Pageable pageable);

    Page<DonHang> findAllSearchDay(String startDay, String endDay, Pageable pageable);

    List<DonHangDto> findAllByTop(int top);
}
