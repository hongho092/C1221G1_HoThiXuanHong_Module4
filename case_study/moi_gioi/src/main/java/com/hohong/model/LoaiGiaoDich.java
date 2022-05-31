package com.hohong.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_giao_dich")
public class LoaiGiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiGiaoDich;
    private String tenLoaiGiaoDich;

    @OneToMany(mappedBy = "loaiGiaoDich")
    private List<GiaoDich> giaoDichList;

    public LoaiGiaoDich() {
    }

    public LoaiGiaoDich(int maLoaiGiaoDich, String tenLoaiGiaoDich, List<GiaoDich> giaoDichList) {
        this.maLoaiGiaoDich = maLoaiGiaoDich;
        this.tenLoaiGiaoDich = tenLoaiGiaoDich;
        this.giaoDichList = giaoDichList;
    }

    public int getMaLoaiGiaoDich() {
        return maLoaiGiaoDich;
    }

    public void setMaLoaiGiaoDich(int maLoaiGiaoDich) {
        this.maLoaiGiaoDich = maLoaiGiaoDich;
    }

    public String getTenLoaiGiaoDich() {
        return tenLoaiGiaoDich;
    }

    public void setTenLoaiGiaoDich(String tenLoaiGiaoDich) {
        this.tenLoaiGiaoDich = tenLoaiGiaoDich;
    }

    public List<GiaoDich> getGiaoDichList() {
        return giaoDichList;
    }

    public void setGiaoDichList(List<GiaoDich> giaoDichList) {
        this.giaoDichList = giaoDichList;
    }
}
