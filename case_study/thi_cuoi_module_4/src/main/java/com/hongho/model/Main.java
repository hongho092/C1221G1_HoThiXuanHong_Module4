package com.hongho.model;

import javax.persistence.*;

@Entity
@Table(name = "")
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maGiaoDich;
    private String codeGiaoDich;
    private String ngayGiaoDich;
    private String donGia;
    private String dienTich;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "maKhachHang")
    private Exam khachHang;
}
