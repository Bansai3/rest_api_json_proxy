package com.vfedotov.controllers;

import com.vfedotov.services_layer.request_dto.albums.AddAlbumDto;
import com.vfedotov.services_layer.request_dto.albums.ChangeAlbumDto;
import com.vfedotov.services_layer.request_dto.albums.DeleteAlbumDto;
import com.vfedotov.services_layer.response_dto.AlbumDto;
import com.vfedotov.services_layer.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumsController {


    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AlBUMS')")
    public AlbumDto getAlbum(@PathVariable("id") Long albumId)
            throws URISyntaxException, IOException, InterruptedException {
        return albumService.getAlbum(albumId);
    }

    @GetMapping("/albums")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AlBUMS')")
    public List<AlbumDto> getAlbums()
            throws URISyntaxException, IOException, InterruptedException {
        return albumService.getAlbums();
    }

    @PostMapping("/albums")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AlBUMS')")
    public void addAlbum(@RequestBody @Valid AddAlbumDto addAlbumDto)
            throws IOException, URISyntaxException, InterruptedException {
        albumService.addAlbum(addAlbumDto);
    }

    @PutMapping("/albums/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AlBUMS')")
    public void changeAlbum(@PathVariable("id") Long albumId, @RequestBody @Valid ChangeAlbumDto changeAlbumDto)
            throws IOException, URISyntaxException, InterruptedException {
        changeAlbumDto.setId(albumId);
        albumService.changeAlbum(changeAlbumDto);
    }


    @DeleteMapping ("/albums/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_AlBUMS')")
    public void deleteAlbum(@PathVariable("id") Long albumId, @RequestBody @Valid DeleteAlbumDto deleteAlbumDto)
            throws URISyntaxException, IOException, InterruptedException {
        deleteAlbumDto.setId(albumId);
        albumService.deleteAlbum(deleteAlbumDto);
    }

}
