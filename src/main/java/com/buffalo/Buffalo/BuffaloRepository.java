package com.buffalo.Buffalo;

import org.springframework.data.repository.CrudRepository;

import com.buffalo.Buffalo.Buffalo;
import java.util.ArrayList;
import java.util.List;

public interface BuffaloRepository extends CrudRepository<Buffalo, Integer> {
    //List<Buffalo> findBy();
 
}
