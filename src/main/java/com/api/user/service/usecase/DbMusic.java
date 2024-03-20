package com.api.user.service.usecase;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import com.api.user.infra.database.mysql.repositories.MysqlMusicRepository;
import com.api.user.infra.database.mysql.repositories.MysqlMusicRepositoryBuilder;
import com.api.user.model.usecase.music.Music;
import com.api.user.model.usecase.music.MusicInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DbMusic implements Music {
    private final MysqlMusicRepository musicRepository;
    private final MysqlMusicRepositoryBuilder musicRepositoryBuilder;

    @Autowired
    public DbMusic(MysqlMusicRepository musicRepository, MysqlMusicRepositoryBuilder musicRepositoryBuilder) {
        this.musicRepository = musicRepository;
        this.musicRepositoryBuilder = musicRepositoryBuilder;
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

    @Override
    public MusicJpaEntity getMusicById(String id) {
        UUID uuidConverted = UUID.fromString((id));
        Optional<MusicJpaEntity> musicOptional = this.musicRepository.findById(uuidConverted);
        return musicOptional.orElse(null);
    }

    @Override
    public List<MusicJpaEntity> getMusicByField(String field, String value) {
        return this.musicRepositoryBuilder.findByField(field, value);
    }

    @Override
    public void setMusicById(String id, MusicInput.SetMusic music) {
        Optional<MusicJpaEntity> optionalMusic = this.musicRepository.findById(UUID.fromString(id));

        if (optionalMusic.isEmpty()) return;

        MusicJpaEntity newMusic = optionalMusic.get();
        newMusic.setTitle(music.getTitle());
        newMusic.setAuthor(music.getAuthor());
        newMusic.setDuration(music.getDuration());
        newMusic.setGenre(music.getGenre());

        this.musicRepository.save(newMusic);
    }
}
