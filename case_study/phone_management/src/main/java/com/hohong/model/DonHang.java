package com.hohong.model;

import javax.persistence.*;

@Entity
@Table(name = "don_hang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDonHang;
    private String ngayMua;
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    public DonHang(int maDonHang, String ngayMua, int soLuong, SanPham sanPham) {
        this.maDonHang = maDonHang;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.sanPham = sanPham;
    }

    public DonHang() {
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
