package com.jellybrains.thural.photoz.clone.services;

import com.jellybrains.thural.photoz.clone.models.Photo;
import com.jellybrains.thural.photoz.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;
    PhotozService(PhotozRepository photozRepository){
        this.photozRepository = photozRepository;
    }
    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }
    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

}
