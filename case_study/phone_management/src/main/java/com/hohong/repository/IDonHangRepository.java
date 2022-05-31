package com.hohong.repository;

import com.hohong.dto.DonHangDto;
import com.hohong.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDonHangRepository extends JpaRepository<DonHang, Integer> {

    @Query(value = "select * from don_hang where don_hang.ngay_mua between :start and :end",
                countQuery = "select * from don_hang where don_hang.ngay_mua between :start and :end",
                nativeQuery = true)
    Page<DonHang> findAllSearchDay(@Param("start") String startDay, @Param("end") String endDay, Pageable pageable);

//    @Query(value = "select don_hang.ma_don_hang maDonHang,don_hang.ngay_mua ngayMua,don_hang.so_luong soLuong,don_hang.ma_san_pham maSanPham  from don_hang join san_pham on don_hang.ma_san_pham = san_pham.ma_san_pham order by (don_hang.so_luong * san_pham.gia_san_pham) DESC LIMIT :top",
//                nativeQuery = true)
//    List<DonHangDto> findAllTop(@Param("top") int numberTop);

    @Query(value = "select don_hang.* from don_hang join san_pham on don_hang.ma_san_pham = san_pham.ma_san_pham order by (don_hang.so_luong * san_pham.gia_san_pham) DESC",
            countQuery = "select don_hang.* from don_hang join san_pham on don_hang.ma_san_pham = san_pham.ma_san_pham order by (don_hang.so_luong * san_pham.gia_san_pham) DESC",
            nativeQuery = true)
    Page<DonHang> findAllTop(Pageable pageable);

//    Integer getMaDonHang();
//    String getNgayMua();
//    String getSoLuong();
//    String getMaSanPham();
}
