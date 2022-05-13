package com.example.dto;

import javax.validation.constraints.*;

public class MusicDto {

    private int id;

    @NotBlank(message = "Can not be blank") /*không khoảng trắng được*/
//    @NotEmpty(message = "cbjzhg") /*khoảng trắng được*/
    @Size(max = 800, message = "Over 800")
    @Pattern(regexp = "[A-Za-z]*", message = "Does not contain special characters")
    private String name;

    @NotBlank(message = "Can not be blank")
    @Size(max = 800, message = "Over 300")
    @Pattern(regexp = "[A-Za-z]*", message = "Does not contain special characters")
    private String singer;

    @NotBlank(message = "Can not be blank")
    @Size(max = 800, message = "Over 1000")
    @Pattern(regexp = "[A-Za-z,]*", message = "Does not contain special characters")
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
