package com.api.user.infra.database.mysql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Setter
@Getter
@Entity
@Table(name = "musics")
public class MusicJpaEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    private String title;
    private String author;
    private String genre;
    private String duration;
}
