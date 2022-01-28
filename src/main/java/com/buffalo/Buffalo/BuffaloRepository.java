package com.buffalo.Buffalo;

import org.springframework.data.repository.CrudRepository;

import com.buffalo.Buffalo.Buffalo;
import java.util.ArrayList;
import java.util.List;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BuffaloRepository extends CrudRepository<Buffalo, Integer> {
    //List<Buffalo> findBy();
 
}
