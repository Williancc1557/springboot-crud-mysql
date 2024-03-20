package com.api.user.controller;

import com.api.user.dto.AddMusicDto;
import com.api.user.dto.EditMusicByIdDto;
import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final Music dbMusic;

    @Autowired
    public MusicController(Music dbMusic) {
        this.dbMusic = dbMusic;
    }

    @PostMapping
    void addMusic(@RequestBody() AddMusicDto music) {
        MusicInput.AddMusic input = new MusicInput.AddMusic(music.title, music.author,  music.genre, music.duration);
        this.dbMusic.addMusic(input);
    }

    @RequestMapping
    List<MusicJpaEntity> getMusic() {
        return this.dbMusic.getAllMusics();
    }

    @RequestMapping("/{musicId}")
    MusicJpaEntity getMusicById(@PathVariable String musicId) {
        return this.dbMusic.getMusicById(musicId);
    }

    @RequestMapping("/field/{field}/{value}")
    List<MusicJpaEntity> getMusicByField(@PathVariable String field, @PathVariable String value) {
        return this.dbMusic.getMusicByField(field, value);
    }

    @PutMapping("/{id}")
    void editMusicById(@PathVariable String id, @RequestBody() EditMusicByIdDto music ) {
        MusicInput.SetMusic setMusicData = new MusicInput.SetMusic(music.title, music.author, music.genre, music.duration);
        this.dbMusic.setMusicById(id, setMusicData);
    }
}
