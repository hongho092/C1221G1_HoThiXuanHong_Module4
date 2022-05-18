package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(Blog blog);

    void edit(Blog blog);

    Page<Blog> findAll(String searchVal, Pageable pageable);

    Page<Blog> findAllPage(Pageable pageable);

    Page<Blog> findBlogByCategory(String nameCategory, Pageable pageable);

    void deleteById(int id);
}
