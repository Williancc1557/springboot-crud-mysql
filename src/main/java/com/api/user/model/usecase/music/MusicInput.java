package com.api.user.model.usecase.music;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MusicInput {
    @AllArgsConstructor
    @Getter
    public static class AddMusic {
        private String title;
        private String author;
        private String genre;
        private String duration;
    }
}
