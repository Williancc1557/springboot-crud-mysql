package com.api.user.infra.database.mysql.repositories;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MysqlMusicRepository extends JpaRepository<MusicJpaEntity, UUID> {
}
