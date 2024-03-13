package com.vfedotov.controllers;

import com.vfedotov.services_layer.request_dto.users.AddUserDto;
import com.vfedotov.services_layer.request_dto.users.ChangeUserDto;
import com.vfedotov.services_layer.request_dto.users.DeleteUserDto;
import com.vfedotov.services_layer.response_dto.UserDto;
import com.vfedotov.services_layer.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
    public UserDto getUser(@PathVariable("id") Long userId)
            throws URISyntaxException, IOException, InterruptedException {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
    public List<UserDto> getUsers()
            throws URISyntaxException, IOException, InterruptedException {
        return userService.getUsers();
    }

    @PostMapping("/users")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
    public void addUser(@RequestBody @Valid AddUserDto addUserDto)
            throws IOException, URISyntaxException, InterruptedException {
        userService.addUser(addUserDto);
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
    public void changeUser(@PathVariable("id") Long userId, @RequestBody @Valid ChangeUserDto changeUserDto)
            throws IOException, URISyntaxException, InterruptedException {
        changeUserDto.setId(userId);
        userService.changeUser(changeUserDto);
    }


    @DeleteMapping ("/users/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USERS')")
    public void deleteUser(@PathVariable("id") Long userId, @RequestBody @Valid DeleteUserDto deleteUserDto)
            throws URISyntaxException, IOException, InterruptedException {
        deleteUserDto.setId(userId);
        userService.deleteUser(deleteUserDto);
    }
}
