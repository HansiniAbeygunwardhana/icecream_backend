package com.icecream.icecream.controller;

import com.google.protobuf.Api;
import com.icecream.icecream.common.ApiResponse;
import com.icecream.icecream.dto.IceCreamDto;
import com.icecream.icecream.model.FileDetail;
import com.icecream.icecream.model.Flavour;
import com.icecream.icecream.model.IceCream;
import com.icecream.icecream.repository.FlavourRepository;
import com.icecream.icecream.repository.IceCreamRepository;
import com.icecream.icecream.service.FileService;
import com.icecream.icecream.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/icecream")
@CrossOrigin(origins = "http://localhost:3000")
public class IceCreamController {
    @Autowired
    IceCreamService iceCreamService;
    @Autowired
    IceCreamRepository iceCreamRepository;
    @Autowired
    FlavourRepository flavourRepository;
    @Autowired
    FileService fileService;

    @GetMapping("/list")
    public ResponseEntity<List<IceCreamDto>> getAllIceCream(){
        List<IceCreamDto> products = iceCreamService.getAllIceCream();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createIceCream(@ModelAttribute IceCreamDto iceCreamDto, @RequestParam("file")MultipartFile file){
        Flavour flavour = flavourRepository.findById(iceCreamDto.getFlavour()).orElse(null);
        if(flavour == null){
            return  new ResponseEntity<ApiResponse>(new ApiResponse(false, "flavour does not exist"), HttpStatus.NOT_FOUND);
        }
        try{
            iceCreamService.createIceCream(iceCreamDto, flavour, file);
            return new ResponseEntity<>(new ApiResponse(true, "IceCream has been added"), HttpStatus.CREATED);
        }catch (IOException e){
            return new ResponseEntity<>(new ApiResponse(false, "Error uploading image"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateIceCream(@PathVariable("id")int id, @ModelAttribute IceCreamDto iceCreamDto, @RequestParam("file")MultipartFile file) throws Exception{

        Flavour flavour = flavourRepository.findById(iceCreamDto.getFlavour()).orElse(null);
        if (flavour == null){
            return new ResponseEntity<>(new ApiResponse(false, "flavour does not exist"), HttpStatus.NOT_FOUND);
        }
        iceCreamService.updateIceCream(iceCreamDto,flavour,id,file);
        return new ResponseEntity<>(new ApiResponse(true, "flavour has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteIceCream(@PathVariable("id") Integer id){

        try {
            iceCreamService.deleteIceCream(id);
            return new ResponseEntity<>(new ApiResponse(true, " IceCream has been deleted"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.NOT_FOUND);
        }
       }

    @GetMapping("/list/{id}")
    public ResponseEntity<IceCreamDto> getIceCreamById(@PathVariable Integer id){
        try {
            IceCreamDto iceCreamDto = iceCreamService.getIceCreamById(id);
            return new ResponseEntity<IceCreamDto>(iceCreamDto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<IceCreamDto>(HttpStatus.NOT_FOUND);
        }
    }
}
