package com.springboot.exam.repository;

import com.springboot.exam.domain.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Alan on 17/6/2017.
 */
public interface BuyerRepository extends MongoRepository<Buyer, String> {
}
