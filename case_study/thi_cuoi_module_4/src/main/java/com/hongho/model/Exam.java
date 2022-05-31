package com.hongho.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "")
public class Exam{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiGiaoDich;
    private String tenLoaiGiaoDich;

    @OneToMany(mappedBy = "loaiGiaoDich")
    private List<Main> giaoDichList;
}
