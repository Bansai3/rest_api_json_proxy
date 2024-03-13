package com.vfedotov.controllers;

import com.vfedotov.services_layer.request_dto.posts.AddPostDto;
import com.vfedotov.services_layer.request_dto.posts.ChangePostDto;
import com.vfedotov.services_layer.request_dto.posts.DeletePostDto;
import com.vfedotov.services_layer.response_dto.PostDto;
import com.vfedotov.services_layer.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
    public PostDto getPost(@PathVariable("id") Long postId)
            throws URISyntaxException, IOException, InterruptedException {
        return postService.getPost(postId);
    }

    @GetMapping("/posts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
    public List<PostDto> getPosts()
            throws URISyntaxException, IOException, InterruptedException {
        return postService.getPosts();
    }

    @PostMapping("/posts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
    public void addPost(@RequestBody @Valid AddPostDto addPostDto)
            throws URISyntaxException, IOException, InterruptedException {
        postService.addPost(addPostDto);
    }

    @PutMapping("/posts/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
    public void changePost(@PathVariable("id") Long postId, @RequestBody @Valid ChangePostDto changePostDto)
            throws IOException, URISyntaxException, InterruptedException {
        changePostDto.setId(postId);
        postService.changePost(changePostDto);
    }


    @DeleteMapping ("/posts/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_POSTS')")
    public void deletePost(@PathVariable("id") Long postId, @RequestBody @Valid DeletePostDto deletePostDto)
            throws IOException, URISyntaxException, InterruptedException {
        deletePostDto.setId(postId);
        postService.deletePost(deletePostDto);
    }

}
