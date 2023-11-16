package com.jellybrains.thural.photoz.clone.repository;

import com.jellybrains.thural.photoz.clone.models.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
