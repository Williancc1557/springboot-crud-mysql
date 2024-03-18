package com.api.user.service.protocols;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;

public interface MusicRepository {
    void addMusic(MusicJpaEntity music);
}
