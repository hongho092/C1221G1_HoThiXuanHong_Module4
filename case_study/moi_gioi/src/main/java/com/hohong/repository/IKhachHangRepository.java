package com.hohong.repository;

import com.hohong.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKhachHangRepository extends JpaRepository<KhachHang, Integer> {
}
