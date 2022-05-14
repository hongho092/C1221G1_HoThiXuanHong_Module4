package com.example.dto;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ProductDto implements Validator {

    @Autowired
    private IProductService productService;

    private int id;

    @NotEmpty(message = "Can not be blank")
    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "The first letter must be capitalized")
    private String name;

    @NotEmpty(message = "Can not be blank")
    private String code;

    @NotEmpty(message = "Can not be blank")
    @Pattern(regexp = "^([1-9][0-9]*|)$", message = "Price cannot be negative")
    private String price;

    @NotEmpty(message = "Can not be blank")
    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "The first letter must be capitalized")
    private String detail;

    @NotEmpty(message = "Can not be blank")
    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "The first letter must be capitalized")
    private String producer;

    private Category category;

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

    public void validate1(Object target, Errors errors, List<Product> productList) {
        ProductDto productDto = (ProductDto) target;
        for (int i=0; i<productList.size(); i++) {
            if (productList.get(i).getCode().equals(productDto.code)) {
                errors.rejectValue("code", "error", "Error");
            }
        }
    }
}
