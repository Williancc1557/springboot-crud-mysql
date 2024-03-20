package com.api.user.model.usecase.music;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;

import java.util.List;

public interface Music {
    void addMusic(MusicInput.AddMusic music);
    List<MusicJpaEntity> getAllMusics();
    MusicJpaEntity getMusicById(String id);
    List<MusicJpaEntity> getMusicByField(String field, String value);
    void setMusicById(String id, MusicInput.SetMusic music);
    void deleteById(String id);
}
