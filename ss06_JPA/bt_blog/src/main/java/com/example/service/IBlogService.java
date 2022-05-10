package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(Blog blog);

    void edit(Blog blog);
}
