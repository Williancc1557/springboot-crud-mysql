package com.api.user.model.usecase.music;

import lombok.AllArgsConstructor;

public class MusicInput {
    @AllArgsConstructor
    public static class AddMusic {
        private String title;
        private String author;
        private String genre;
        private String duration;
    }
}
