package com.icecream.icecream.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import org.springframework.beans.factory.annotation.Value;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class FileService {

    @Value("${gcp.bucket.name}")
    private String bucketName;

    @Autowired
    Storage storage;

    public List<String> listOfFiles() {

        List<String> list = new ArrayList<>();
        Page<Blob> blobs = storage.list(bucketName);
        for (Blob blob : blobs.iterateAll()) {
            String fullUrl = "https://storage.googleapis.com/" + bucketName + "/" + blob.getName();
            list.add(fullUrl);
        }
        return list;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            BlobId blobId = BlobId.of(bucketName, file.getOriginalFilename());
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).
                    setContentType(file.getContentType()).build();
            Blob blob = storage.create(blobInfo,file.getBytes());
            return blob.getMediaLink();
        }
        else {
            return null;
        }
    }
}
