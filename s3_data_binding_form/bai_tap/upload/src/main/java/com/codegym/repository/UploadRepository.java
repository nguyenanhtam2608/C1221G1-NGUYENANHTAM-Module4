package com.codegym.repository;

import com.codegym.model.Upload;

import java.util.List;

public interface UploadRepository {
    public List<Upload> listUpload();

    void save(Upload upload);
}
