package com.hohong.service.impl;

import com.hohong.model.GiaoDich;
import com.hohong.repository.IGiaoDichRepository;
import com.hohong.service.IGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GiaoDichService implements IGiaoDichService{

    @Autowired
    private IGiaoDichRepository giaoDichRepository;

    @Override
    public Page<GiaoDich> findAll1(String searchName, Pageable pageable) {
        return giaoDichRepository.findAllByKhachHang_TenKhachHangContaining(searchName, pageable);
    }

    @Override
    public Page<GiaoDich> findAll2(String searchName, int searchCategory, Pageable pageable) {
        return giaoDichRepository.findAllByKhachHang_TenKhachHangContainingAndLoaiGiaoDich_MaLoaiGiaoDich(searchName, searchCategory, pageable);
    }

    @Override
    public GiaoDich findById(int id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(GiaoDich giaoDich) {
        giaoDichRepository.delete(giaoDich);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }
}
