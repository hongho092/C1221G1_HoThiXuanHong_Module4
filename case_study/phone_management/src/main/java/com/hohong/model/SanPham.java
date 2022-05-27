package com.hohong.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "san_pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSanPham;
    private String tenSanPham;
    private int giaSanPham;
    private String tinhTrangSanPham;

    @ManyToOne
    @JoinColumn(name = "ma_loai_san_pham", referencedColumnName = "maLoaiSanPham")
    private LoaiSanPham loaiSanPham;

    @OneToMany(mappedBy = "sanPham")
    private List<DonHang> donHangList;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, int giaSanPham, String tinhTrangSanPham, LoaiSanPham loaiSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.tinhTrangSanPham = tinhTrangSanPham;
        this.loaiSanPham = loaiSanPham;
    }

    public List<DonHang> getDonHangList() {
        return donHangList;
    }

    public void setDonHangList(List<DonHang> donHangList) {
        this.donHangList = donHangList;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getTinhTrangSanPham() {
        return tinhTrangSanPham;
    }

    public void setTinhTrangSanPham(String tinhTrangSanPham) {
        this.tinhTrangSanPham = tinhTrangSanPham;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
