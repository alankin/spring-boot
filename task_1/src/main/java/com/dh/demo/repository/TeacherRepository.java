package com.dh.demo.repository;

import com.dh.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Alan on 3/6/2017.
 */
public interface TeacherRepository extends MongoRepository<Teacher, String> {


    @Query("{_id : ?0}")
    Teacher getTeacherById(String id);
}
