package com.example.repository;

import com.example.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
//    List<Music> findAll();
//
//    void save(Music music);
//
//    Music findOne(int id);
//
//    void update(Music music);
//
//    void remove(Music music);
}
