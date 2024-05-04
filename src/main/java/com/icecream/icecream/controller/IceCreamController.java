package com.icecream.icecream.controller;

import com.icecream.icecream.repository.IceCreamRepository;
import com.icecream.icecream.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/icecream")
@CrossOrigin(origins = "http://localhost:3000")
public class IceCreamController {
    @Autowired
    IceCreamService iceCreamService;

    @Autowired
    IceCreamRepository iceCreamRepository;
}
