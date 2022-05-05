package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSong();

    void save(Song song);
}
