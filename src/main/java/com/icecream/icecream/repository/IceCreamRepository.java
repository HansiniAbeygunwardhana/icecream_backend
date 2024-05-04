package com.icecream.icecream.repository;

import com.icecream.icecream.model.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream,Integer> {

}
