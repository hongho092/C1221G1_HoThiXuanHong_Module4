package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(String searchVal, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(searchVal, pageable);
    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findBlogByCategory(String nameCategory, Pageable pageable) {
        return iBlogRepository.findAllByCategory_Name(nameCategory, pageable);
    }

    @Override
    public void deleteById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findBySearch(String search) {
        return iBlogRepository.findAllByNameContaining(search);
    }


}
