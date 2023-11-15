package com.jellybrains.thural.photoz.clone.controllers;

import com.jellybrains.thural.photoz.clone.models.Photo;
import com.jellybrains.thural.photoz.clone.services.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class PhotozController {
    private final PhotozService photozService;

    public PhotozController(PhotozService photozService){
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photoz")
    Collection<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    Photo get(@PathVariable String id){
        Photo photo = photozService.get(id);
        if(photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    Photo delete(@PathVariable String id){
        Photo photo = photozService.remove(id);
        if(photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @PostMapping("/photoz")
    Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
