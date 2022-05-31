package com.hohong.model;

import javax.persistence.*;

@Entity
@Table(name = "giao_dich")
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maGiaoDich;
    private String codeGiaoDich;
    private String ngayGiaoDich;
    private String donGia;
    private String dienTich;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "ma_loai_giao_dich", referencedColumnName = "maLoaiGiaoDich")
    private LoaiGiaoDich loaiGiaoDich;

    public GiaoDich() {
    }

    public GiaoDich(int maGiaoDich, String codeGiaoDich, String ngayGiaoDich, String donGia, String dienTich, KhachHang khachHang, LoaiGiaoDich loaiGiaoDich) {
        this.maGiaoDich = maGiaoDich;
        this.codeGiaoDich = codeGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.khachHang = khachHang;
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public String getCodeGiaoDich() {
        return codeGiaoDich;
    }

    public void setCodeGiaoDich(String codeGiaoDich) {
        this.codeGiaoDich = codeGiaoDich;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiGiaoDich getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(LoaiGiaoDich loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }
}

