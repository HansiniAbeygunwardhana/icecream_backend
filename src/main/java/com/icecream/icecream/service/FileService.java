package com.icecream.icecream.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.icecream.icecream.model.FileDetail;
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

    public FileDetail uploadFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            BlobId blobId = BlobId.of(bucketName, file.getOriginalFilename());
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).
                    setContentType(file.getContentType()).build();
            Blob blob = storage.create(blobInfo,file.getBytes());
//            return blob.getMediaLink();
            return new FileDetail(blob.getMediaLink(), blob.getName());
        }
        else {
            return null;
        }
    }

    public boolean deleteFile(String fileName){
        System.out.println(fileName);
        Blob blob = storage.get(bucketName, fileName);
        return blob.delete();
    }

    public FileDetail updateFile(MultipartFile file, String fileName) throws IOException{
        deleteFile(fileName);

        return uploadFile(file);
    }
}
