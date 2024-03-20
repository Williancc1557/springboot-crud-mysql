package com.api.user.service.usecase;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.infra.database.mysql.repositories.MysqlMusicRepository;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbMusic implements Music {
    private final MysqlMusicRepository musicRepository;

    @Autowired
    public DbMusic(MysqlMusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @Override
    public void addMusic(MusicInput.AddMusic music) {
        MusicJpaEntity musicJpaEntity = new MusicJpaEntity();
        musicJpaEntity.setTitle(music.getTitle());
        musicJpaEntity.setAuthor(music.getAuthor());
        musicJpaEntity.setDuration(music.getDuration());
        musicJpaEntity.setGenre(music.getGenre());

        this.musicRepository.save(musicJpaEntity);
    }

    @Override
    public List<MusicJpaEntity> getAllMusics() {
        return this.musicRepository.findAll();
    }
}
