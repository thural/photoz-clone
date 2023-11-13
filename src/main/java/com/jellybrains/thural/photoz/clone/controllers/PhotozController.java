package com.jellybrains.thural.photoz.clone.controllers;

import com.jellybrains.thural.photoz.clone.models.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class PhotozController {
    Map <String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photoz")
    Collection<Photo> get(){
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if(photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    Photo delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if(photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @PostMapping("/photoz")
    Photo create(@RequestBody Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
}
