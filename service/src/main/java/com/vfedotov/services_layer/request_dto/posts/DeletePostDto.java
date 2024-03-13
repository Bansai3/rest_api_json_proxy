package com.vfedotov.services_layer.request_dto.posts;

import jakarta.validation.constraints.Positive;

public class DeletePostDto {
    @Positive(message = "id must be positive!")
    private long id;

    public DeletePostDto() {
    }

    public @Positive(message = "id must be positive!") long getId() {
        return this.id;
    }

    public void setId(@Positive(message = "id must be positive!") long id) {
        this.id = id;
    }
}
