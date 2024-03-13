package com.vfedotov.services_layer.response_dto;

public class PostDto {
    private long userId;

    private long id;

    private String title;

    private String body;

    public PostDto() {
    }

    public long getUserId() {
        return this.userId;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
