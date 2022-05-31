package com.hohong.repository;

import com.hohong.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiaoDichRepository extends JpaRepository<GiaoDich, Integer> {

    Page<GiaoDich> findAllByKhachHang_TenKhachHangContaining(String name, Pageable pageable);

    Page<GiaoDich> findAllByKhachHang_TenKhachHangContainingAndLoaiGiaoDich_MaLoaiGiaoDich(String name, int category, Pageable pageable);
}
