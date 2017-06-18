package com.springboot.exam.repository;

import com.springboot.exam.domain.RegistryCarSold;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Alan on 17/6/2017.
 */
public interface RegistryCarSoldRepository extends MongoRepository<RegistryCarSold, String> {

    @Query("{ 'seller.id' : ?0 }")
    RegistryCarSold findRegistriesBySeller(String id);

}
