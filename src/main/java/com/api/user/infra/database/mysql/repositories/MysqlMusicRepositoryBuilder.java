package com.api.user.infra.database.mysql.repositories;

import com.api.user.infra.database.mysql.entities.MusicJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MysqlMusicRepositoryBuilder {
    @PersistenceContext
    EntityManager entityManager;

    public List<MusicJpaEntity> findByField(String field, String value) {
        String queryString = "SELECT m FROM MusicJpaEntity m WHERE m." + field + " = :value";
        TypedQuery<MusicJpaEntity> query = this.entityManager.createQuery(queryString, MusicJpaEntity.class);
        query.setParameter("value", value);
        return query.getResultList();
    }
}
