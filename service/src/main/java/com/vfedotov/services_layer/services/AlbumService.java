package com.vfedotov.services_layer.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vfedotov.dao_layer.dao.AuditRecordRepository;
import com.vfedotov.services_layer.request_dto.albums.AddAlbumDto;
import com.vfedotov.services_layer.request_dto.albums.ChangeAlbumDto;
import com.vfedotov.services_layer.request_dto.albums.DeleteAlbumDto;
import com.vfedotov.services_layer.response_dto.AlbumDto;
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
public class AlbumService {

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private final String url = "https://jsonplaceholder.typicode.com/albums";

    public List<AlbumDto> getAlbums() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<AlbumDto> aldtos = mapper.readValue(response.body(), new TypeReference<List<AlbumDto>>() {});

        return aldtos;
    }

    public AlbumDto getAlbum(Long id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + id))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();

        AlbumDto aldto = mapper.readValue(response.body(), new TypeReference<AlbumDto>() {});

        return aldto;
    }

    public void addAlbum(AddAlbumDto addAlbumDto) throws IOException, URISyntaxException, InterruptedException {
        String json = ow.writeValueAsString(addAlbumDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void changeAlbum(ChangeAlbumDto changeAlbumDto) throws IOException, URISyntaxException, InterruptedException {
        String json = ow.writeValueAsString(changeAlbumDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + changeAlbumDto.getId()))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void deleteAlbum(DeleteAlbumDto deleteAlbumDto) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + deleteAlbumDto.getId()))
                .DELETE()
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
