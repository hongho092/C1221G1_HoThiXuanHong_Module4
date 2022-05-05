package com.example.repository;

import com.example.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepositoryImpl implements SongRepository{

    private static List<Song> songList = new ArrayList<>();

    static {
        songList.add(new Song("abc1", "abcd", "pop", "https://james.codegym.vn/mod/assign/view.php?id=12657"));
        songList.add(new Song("abc2", "abcd", "rock", "https://james.codegym.vn/mod/assign/view.php?id=12657"));
    }

    @Override
    public List<Song> getAllSong() {
        List<Song> songs = songList;
        return songs;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
