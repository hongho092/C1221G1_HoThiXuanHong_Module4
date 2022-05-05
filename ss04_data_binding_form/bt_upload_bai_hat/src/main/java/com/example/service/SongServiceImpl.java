package com.example.service;

import com.example.model.Song;
import com.example.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSong() {
        List<Song> songs = songRepository.getAllSong();
        return songs;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
