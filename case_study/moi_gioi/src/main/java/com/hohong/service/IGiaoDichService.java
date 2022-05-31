package com.hohong.service;

import com.hohong.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGiaoDichService {
    Page<GiaoDich> findAll1(String searchName, Pageable pageable);

    Page<GiaoDich> findAll2(String searchName, int searchCategory, Pageable pageable);

    GiaoDich findById(int id);

    void delete(GiaoDich giaoDich);

    void save(GiaoDich giaoDich);
}
