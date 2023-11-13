package com.jellybrains.thural.photoz.clone.models;

public class Photo {
    private String id;
    private String fileName;

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }


    // add raw data later on


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
