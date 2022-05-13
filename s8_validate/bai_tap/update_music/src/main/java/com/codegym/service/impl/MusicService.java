package com.codegym.service.impl;


import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;

import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;


    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(Music music) {
        iMusicRepository.delete(music);
    }


//    @Override
//    public void remove(int id) {
//        musicRepository.remove(id);
//    }
}
