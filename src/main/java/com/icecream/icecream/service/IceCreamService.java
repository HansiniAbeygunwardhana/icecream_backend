package com.icecream.icecream.service;

import com.icecream.icecream.dto.IceCreamDto;
import com.icecream.icecream.model.Flavour;
import com.icecream.icecream.model.IceCream;
import com.icecream.icecream.repository.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return new IceCreamDto(iceCream.getIceCreamId(), iceCream.getIceCreamName(), iceCream.getFlavour().getFlavourId(), iceCream.getIceCreamDescription(), iceCream.getRating(), iceCream.getPrice(), iceCream.getQuantity(), iceCream.getImgUrl());
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
        String imageUrl;
        if (file != null && !file.isEmpty()){
            imageUrl = fileService.uploadFile(file);
        }else{
            imageUrl = null;
        }
        IceCream iceCream = new IceCream();
        iceCream.setIceCreamName(iceCreamDto.getIceCreamName());
        iceCream.setIceCreamDescription(iceCreamDto.getIceCreamDescription());
        iceCream.setRating(iceCreamDto.getRating());
        iceCream.setPrice(iceCreamDto.getPrice());
        iceCream.setQuantity(iceCreamDto.getQuantity());
        iceCream.setImgUrl(imageUrl);
        iceCream.setFlavour(flavour);
        iceCreamRepository.save(iceCream);
    }
}
