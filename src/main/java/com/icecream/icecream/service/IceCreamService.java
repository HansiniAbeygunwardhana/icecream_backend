package com.icecream.icecream.service;

import com.icecream.icecream.common.ApiResponse;
import com.icecream.icecream.dto.IceCreamDto;
import com.icecream.icecream.model.FileDetail;
import com.icecream.icecream.model.Flavour;
import com.icecream.icecream.model.IceCream;
import com.icecream.icecream.repository.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IceCreamService {

    @Autowired
    IceCreamRepository iceCreamRepository;
    @Autowired
    FileService fileService;

    public IceCreamDto getIceCreamDto(IceCream iceCream){
        return new IceCreamDto(iceCream.getIceCreamId(), iceCream.getIceCreamName(), iceCream.getFlavour().getFlavourId(), iceCream.getIceCreamDescription(), iceCream.getRating(), iceCream.getPrice(), iceCream.getQuantity(), iceCream.getImgUrl(), iceCream.getImgName(), iceCream.getAllergerns(), iceCream.getIngredients());
    }
    public List<IceCreamDto> getAllIceCream(){
        List<IceCream> allIceCream = iceCreamRepository.findAll();
        List<IceCreamDto> allIceCreamDto = new ArrayList<>();
        for (IceCream iceCream:allIceCream){
            allIceCreamDto.add(getIceCreamDto(iceCream));
        }
        return allIceCreamDto;
    }

    public void createIceCream(IceCreamDto iceCreamDto, Flavour flavour, MultipartFile file) throws IOException{
        FileDetail fileDetail;

        if (file != null && !file.isEmpty()){
            fileDetail = fileService.uploadFile(file);
        }else{
            fileDetail = null;
        }
        IceCream iceCream = new IceCream();
        iceCream.setIceCreamName(iceCreamDto.getIceCreamName());
        iceCream.setIceCreamDescription(iceCreamDto.getIceCreamDescription());
        iceCream.setRating(iceCreamDto.getRating());
        iceCream.setPrice(iceCreamDto.getPrice());
        iceCream.setQuantity(iceCreamDto.getQuantity());
        iceCream.setImgUrl(fileDetail.getImgUrl());
        iceCream.setImgName(fileDetail.getFileName());
        iceCream.setFlavour(flavour);
        iceCream.setAllergerns(iceCreamDto.getAllegerns());
        iceCream.setIngredients(iceCreamDto.getIngredients());
        iceCreamRepository.save(iceCream);
    }

    public void updateIceCream(IceCreamDto iceCreamDto, Flavour flavour,Integer id, MultipartFile file) throws Exception{
        IceCream iceCream = iceCreamRepository.findById(id).orElse(null);
        if(iceCream == null){
            throw new Exception("no existing ice cream");
        }
        FileDetail fileDetail = fileService.updateFile(file, iceCream.getImgName());
        System.out.println(file.getOriginalFilename());
        System.out.println(iceCreamDto.getIceCreamName());
        iceCream.setIceCreamName(iceCreamDto.getIceCreamName());
        iceCream.setIceCreamDescription(iceCreamDto.getIceCreamDescription());
        iceCream.setRating(iceCreamDto.getRating());
        iceCream.setPrice(iceCreamDto.getPrice());
        iceCream.setQuantity(iceCreamDto.getQuantity());
        iceCream.setImgUrl(fileDetail.getImgUrl());
        iceCream.setImgName(fileDetail.getFileName());
        iceCream.setFlavour(flavour);
        iceCream.setAllergerns(iceCreamDto.getAllegerns());
        iceCream.setIngredients(iceCreamDto.getIngredients());
        iceCreamRepository.save(iceCream);
    }

    public boolean findById(int id){
        return iceCreamRepository.findById(id).isPresent();
    }

    public void deleteIceCream(Integer id) throws Exception {
        IceCream iceCream = iceCreamRepository.findById(id).orElse(null);
        if(iceCream == null){
            throw new Exception("no existing ice cream");
        }

        if (fileService.deleteFile(iceCream.getImgName())){
            iceCreamRepository.delete(iceCream);
        } else {
            throw new Exception("Error Deleting file");
        }

    }

    public IceCreamDto getIceCreamById(Integer id) throws Exception {
        IceCream iceCream = iceCreamRepository.findById(id).orElse(null);
        if(iceCream == null){
            throw new Exception("no existing ice cream");
        }
        return getIceCreamDto(iceCream);

    }
}
