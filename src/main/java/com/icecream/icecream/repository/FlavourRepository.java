package com.icecream.icecream.repository;

import com.icecream.icecream.model.Flavour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavourRepository extends JpaRepository<Flavour, Integer>{
    Flavour findNameByFlavourName(String flavourName);
}
