package com.vfedotov.services_layer.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vfedotov.dao_layer.dao.AuditRecordRepository;
import com.vfedotov.services_layer.request_dto.posts.AddPostDto;
import com.vfedotov.services_layer.request_dto.posts.ChangePostDto;
import com.vfedotov.services_layer.request_dto.posts.DeletePostDto;
import com.vfedotov.services_layer.response_dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private final String  url = "https://jsonplaceholder.typicode.com/posts";

    private final HttpClient client = HttpClient.newHttpClient();


    public List<PostDto> getPosts() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                              .GET()
                              .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<PostDto> pdtos = mapper.readValue(response.body(), new TypeReference<List<PostDto>>() {});

        return pdtos;
    }

    public PostDto getPost(Long id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();

        PostDto pdto = mapper.readValue(response.body(), new TypeReference<PostDto>() {});

        return pdto;
    }

    public void addPost(AddPostDto addPostDto) throws URISyntaxException, IOException, InterruptedException {
        String json = ow.writeValueAsString(addPostDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void changePost(ChangePostDto changePostDto) throws IOException, URISyntaxException, InterruptedException {
        String json = ow.writeValueAsString(changePostDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + changePostDto.getId()))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void deletePost(DeletePostDto deletePostDto) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + deletePostDto.getId()))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
