package com.api.user.service.usecase;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import com.api.user.service.protocols.MusicRepository;
import org.springframework.stereotype.Component;

@Component
public class DbMusic implements Music {
    private MusicRepository musicRepository;

    @Override
    public void addMusic(MusicInput.AddMusic music) {
        MusicJpaEntity musicJpaEntity = new MusicJpaEntity();
        musicJpaEntity.setTitle(music.getTitle());
        musicJpaEntity.setAuthor(music.getAuthor());
        musicJpaEntity.setDuration(music.getDuration());
        musicJpaEntity.setGenre(music.getGenre());

        this.musicRepository.addMusic(musicJpaEntity);
    }
}
