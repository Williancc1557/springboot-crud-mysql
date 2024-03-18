package com.api.user.controller;

import com.api.user.controller.dto.AddMusicDto;
import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MusicController {
    private Music dbMusic;
    @PostMapping("/music")
    void addMusic(@RequestBody() AddMusicDto music) {
        MusicInput.AddMusic input = new MusicInput.AddMusic(music.title, music.author,  music.genre, music.duration);
        this.dbMusic.addMusic(input);
    }
}
