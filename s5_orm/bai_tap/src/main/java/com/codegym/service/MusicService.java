package com.codegym.service;


import com.codegym.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();
    void save(Music music);

    Music findById(int id);

    void update( Music music);



    void remove(Music music);
}
