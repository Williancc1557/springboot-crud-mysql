package com.api.user.controller;

import com.api.user.controller.dto.AddMusicDto;
import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    private final Music dbMusic;

    @Autowired
    public MusicController(Music dbMusic) {
        this.dbMusic = dbMusic;
    }

    @PostMapping("/music")
    void addMusic(@RequestBody() AddMusicDto music) {
        MusicInput.AddMusic input = new MusicInput.AddMusic(music.title, music.author,  music.genre, music.duration);
        this.dbMusic.addMusic(input);
    }
}
