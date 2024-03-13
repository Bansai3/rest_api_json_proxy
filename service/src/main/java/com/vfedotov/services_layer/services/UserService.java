package com.vfedotov.services_layer.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vfedotov.dao_layer.dao.AuditRecordRepository;
import com.vfedotov.services_layer.request_dto.users.AddUserDto;
import com.vfedotov.services_layer.request_dto.users.ChangeUserDto;
import com.vfedotov.services_layer.request_dto.users.DeleteUserDto;
import com.vfedotov.services_layer.response_dto.UserDto;
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
public class UserService {

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private final String url = "https://jsonplaceholder.typicode.com/users";

    private final HttpClient client = HttpClient.newHttpClient();

    public List<UserDto> getUsers() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<UserDto>>() {});
    }

    public UserDto getUser(Long id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body(), new TypeReference<UserDto>() {});
    }

    public void addUser(AddUserDto addUsersDto) throws IOException, URISyntaxException, InterruptedException {
        String json = ow.writeValueAsString(addUsersDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void changeUser(ChangeUserDto changeUserDto) throws IOException, URISyntaxException, InterruptedException {
        String json = ow.writeValueAsString(changeUserDto);

        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + changeUserDto.getId()))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void deleteUser(DeleteUserDto deleteUserDto) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url + "/" + deleteUserDto.getId()))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
