package com.hohong.dto;

import com.hohong.model.KhachHang;
import com.hohong.model.LoaiGiaoDich;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class GiaoDichDto implements Validator {


    private int maGiaoDich;

    @Pattern(regexp = "^MGD-[0-9]{4}$", message = "Không đúng định dạng mã")
    private String codeGiaoDich;

    private String ngayGiaoDich;

    @Pattern(regexp = "^[5-9][0-9]{5,}$", message = "Phải lớn hơn 500.000 VND")
    private String donGia;

    @Pattern(regexp = "^[2-9][0-9]{1,}$", message = "Phải lớn hơn 20 m2")
    private String dienTich;

    private KhachHang khachHang;
    private LoaiGiaoDich loaiGiaoDich;

    public GiaoDichDto() {
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
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

    public String getCodeGiaoDich() {
        return codeGiaoDich;
    }

    public void setCodeGiaoDich(String codeGiaoDich) {
        this.codeGiaoDich = codeGiaoDich;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiaoDichDto giaoDichDto = (GiaoDichDto) target;

        if (!LocalDate.parse(giaoDichDto.ngayGiaoDich).isAfter(LocalDate.now())) {
            errors.rejectValue("ngayGiaoDich", "error", "default error");
        }
//        if (current1 > 0) {
//        errors.rejectValue("contractStartDate", "day_error1", "Error");
//        }
//        for (int i=0; i<productList.size(); i++) {
//            if (productList.get(i).getCode().equals(productDto.code)) {
//                errors.rejectValue("code", "error", "Error");
//            }
//        }
    }
}


//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    LocalDate startDate = LocalDate.parse(contractDto.contractStartDate, formatter);
//    LocalDate endDate = LocalDate.parse(contractDto.contractEndDate, formatter);
//    LocalDate now = LocalDate.now();
//    int current1 = Period.between(startDate, now).getDays();
//    int current2 = Period.between(endDate, startDate).getDays();
//        if (current1 > 0) {
//        errors.rejectValue("contractStartDate", "day_error1", "Error");
//        }
//        if (current2 > 0) {
//        errors.rejectValue("contractEndDate", "day_error2", "Error");
//        }


//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    LocalDate age = LocalDate.parse(customerDto.customerBirthday, formatter);
//    LocalDate now = LocalDate.now();
//    int current = Period.between(age, now).getYears();
//    if (current < 18) {
//    errors.rejectValue("customerBirthday", "age_error1", "Error");
//    } else if (current > 100) {
//    errors.rejectValue("customerBirthday", "age_error2", "Error");
//    }