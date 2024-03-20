package com.api.user.infra.database.mysql.repositories;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MysqlMusicRepository extends JpaRepository<MusicJpaEntity, UUID> {
}
