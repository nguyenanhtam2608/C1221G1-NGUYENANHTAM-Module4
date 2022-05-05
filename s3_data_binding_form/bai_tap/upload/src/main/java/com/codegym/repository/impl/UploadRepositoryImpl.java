package com.codegym.repository.impl;

import com.codegym.model.Upload;
import com.codegym.repository.UploadRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UploadRepositoryImpl implements UploadRepository {
   static List<Upload> uploadList=new ArrayList<>();
    static {
        uploadList.add(new Upload("Có nhưng không ở lại", "Hiền Hồ", "Hip Hóp", "hienho.mp3 "));
        uploadList.add(new Upload("Có nhưng không ở lại", "Hiền Hồ", "Hip Hóp", "hienho.mp3"));
        uploadList.add(new Upload("Có nhưng không ở lại", "Hiền Hồ", "Hip Hóp", "hienho.mp3"));
    }
    @Override
    public List<Upload> listUpload() {
        return uploadList;
    }

    @Override
    public void save(Upload upload) {
        uploadList.add(upload);
    }
}
