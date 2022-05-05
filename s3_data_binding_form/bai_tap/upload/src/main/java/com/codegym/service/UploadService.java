package com.codegym.service;

import com.codegym.model.Upload;

import java.util.List;

public interface UploadService {
    public List<Upload> listUpload();

    void save(Upload upload);
}
