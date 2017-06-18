package com.springboot.exam.repository;

import com.springboot.exam.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Alan on 17/6/2017.
 */
public interface CarRepository extends MongoRepository<Car, String> {
}
