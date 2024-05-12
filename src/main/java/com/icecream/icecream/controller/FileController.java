package com.icecream.icecream.controller;

import com.icecream.icecream.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping
    public ResponseEntity<java.util.List<String>> listOfFiles() {

        List<String> files = fileService.listOfFiles();

        return ResponseEntity.ok(files);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file)throws IOException{
        fileService.uploadFile(file);
        return ResponseEntity.ok("file uploaded successfully");
    }

}
