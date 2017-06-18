package com.dh.demo.repository;

import com.dh.demo.domain.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Alan on 10/6/2017.
 */
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
