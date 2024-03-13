package com.vfedotov.services_layer.request_dto.posts;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class AddPostDto {
    @NotEmpty(message = "title should not be empty!")
    private String title;

    @NotEmpty(message = "body should not be empty!")
    private String body;

    @Positive(message = "id must be positive!")
    private long userId;

    public AddPostDto() {
    }

    public @NotEmpty(message = "title should not be empty!") String getTitle() {
        return this.title;
    }

    public @NotEmpty(message = "body should not be empty!") String getBody() {
        return this.body;
    }

    public @Positive(message = "id must be positive!") long getUserId() {
        return this.userId;
    }

    public void setTitle(@NotEmpty(message = "title should not be empty!") String title) {
        this.title = title;
    }

    public void setBody(@NotEmpty(message = "body should not be empty!") String body) {
        this.body = body;
    }

    public void setUserId(@Positive(message = "id must be positive!") long userId) {
        this.userId = userId;
    }
}
