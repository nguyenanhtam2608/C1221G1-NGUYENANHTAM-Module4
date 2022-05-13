package com.codegym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {

    Integer id;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không được nhật kí tự đặt biệt")
    String nameSong;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không được nhật kí tự đặt biệt")
    String nameSinger;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9/,]*$", message = "Không được nhật kí tự đặt biệt , Ngoại trừ dấu phẩy “,” ")
    String category;

    String link;

    public MusicDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
