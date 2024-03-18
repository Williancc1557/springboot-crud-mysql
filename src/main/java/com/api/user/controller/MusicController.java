package com.api.user.controller;

import com.api.user.model.entities.mysql.MusicJpaEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MusicController {
    @PostMapping("/")
    void addMusic(@RequestBody() MusicJpaEntity music) {

    }
}
