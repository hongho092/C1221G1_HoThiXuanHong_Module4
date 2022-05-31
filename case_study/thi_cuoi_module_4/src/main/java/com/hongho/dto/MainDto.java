package com.hongho.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MainDto implements Validator {



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        MainDto mainDto = (MainDto) target;

//        if (!LocalDate.parse(giaoDichDto.ngayGiaoDich).isAfter(LocalDate.now())) {
//            errors.rejectValue("ngayGiaoDich", "error", "default error");
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