package com.vfedotov.services_layer.request_dto.users;

import jakarta.validation.constraints.Positive;

public class DeleteUserDto {
    @Positive(message = "id must be positive!")
    private long id;

    public DeleteUserDto() {
    }

    public @Positive(message = "id must be positive!") long getId() {
        return this.id;
    }

    public void setId(@Positive(message = "id must be positive!") long id) {
        this.id = id;
    }
}
