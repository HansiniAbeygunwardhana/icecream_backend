package com.icecream.icecream.service;

import com.icecream.icecream.repository.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IceCreamService {
    @Autowired
    IceCreamRepository iceCreamRepository;
}
