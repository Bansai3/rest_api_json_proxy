package com.vfedotov.services_layer.request_dto.albums;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class ChangeAlbumDto {
    @Positive(message = "id must be positive!")
    private long userId;

    @Positive(message = "id must be positive!")
    private long id;

    @NotEmpty(message = "title should not be empty!")
    private String title;

    public ChangeAlbumDto() {
    }

    public @Positive(message = "id must be positive!") long getUserId() {
        return this.userId;
    }

    public @Positive(message = "id must be positive!") long getId() {
        return this.id;
    }

    public @NotEmpty(message = "title should not be empty!") String getTitle() {
        return this.title;
    }

    public void setUserId(@Positive(message = "id must be positive!") long userId) {
        this.userId = userId;
    }

    public void setId(@Positive(message = "id must be positive!") long id) {
        this.id = id;
    }

    public void setTitle(@NotEmpty(message = "title should not be empty!") String title) {
        this.title = title;
    }
}
