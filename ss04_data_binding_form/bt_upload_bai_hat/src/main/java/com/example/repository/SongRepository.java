package com.example.repository;

import com.example.model.Song;

import java.util.List;

public interface SongRepository {
    List<Song> getAllSong();

    void save(Song song);
}
