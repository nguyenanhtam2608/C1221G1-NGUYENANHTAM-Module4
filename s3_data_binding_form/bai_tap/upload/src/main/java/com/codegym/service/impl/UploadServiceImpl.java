package com.codegym.service.impl;

import com.codegym.model.Upload;
import com.codegym.repository.UploadRepository;
import com.codegym.repository.impl.UploadRepositoryImpl;
import com.codegym.service.UploadService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UploadServiceImpl implements UploadService {
    UploadRepository uploadRepository = new UploadRepositoryImpl();

    @Override
    public List<Upload> listUpload() {
        return uploadRepository.listUpload();
    }

    @Override
    public void save(Upload upload) {
        this.uploadRepository.save(upload);
    }
}
