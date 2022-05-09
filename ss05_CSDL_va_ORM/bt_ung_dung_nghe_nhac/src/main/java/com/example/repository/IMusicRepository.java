package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findOne(int id);

    void update(Music music);

    void remove(Music music);
}
