package com.vfedotov.services_layer.request_dto.posts;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class ChangePostDto {

    @Positive(message = "id must be positive!")
    private long id;

    @NotEmpty(message = "title should not be empty!")
    private String title;

    @NotEmpty(message = "body should not be empty!")
    private String body;

    @Positive(message = "id must be positive!")
    private long userId;

    public ChangePostDto() {
    }

    public @Positive(message = "id must be positive!") long getId() {
        return this.id;
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

    public void setId(@Positive(message = "id must be positive!") long id) {
        this.id = id;
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
