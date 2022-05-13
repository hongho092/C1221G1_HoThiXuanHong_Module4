package com.example.dto;

import javax.validation.constraints.NotBlank;

public class MusicDto {

    private int id;

    @NotBlank(message = "Can not be blank")
    private String name;

    @NotBlank(message = "Can not be blank")
    private String singer;

    @NotBlank(message = "Can not be blank")
    private String kindOfMusic;

    @NotBlank(message = "Can not be blank")
    private String path;

    public MusicDto() {
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
