package com.vfedotov.services_layer.request_dto.albums;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class AddAlbumDto {
    @Positive(message = "id must be positive!")
    private long userId;

    @NotEmpty(message = "title should not be empty!")
    private String title;

    public AddAlbumDto() {
    }

    public @Positive(message = "id must be positive!") long getUserId() {
        return this.userId;
    }

    public @NotEmpty(message = "title should not be empty!") String getTitle() {
        return this.title;
    }

    public void setUserId(@Positive(message = "id must be positive!") long userId) {
        this.userId = userId;
    }

    public void setTitle(@NotEmpty(message = "title should not be empty!") String title) {
        this.title = title;
    }
}
