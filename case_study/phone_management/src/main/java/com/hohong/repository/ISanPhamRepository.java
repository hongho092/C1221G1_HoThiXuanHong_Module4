package com.hohong.repository;

import com.hohong.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
}
