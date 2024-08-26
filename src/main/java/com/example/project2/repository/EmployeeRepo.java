package com.example.project2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.project2.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String>{

}
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Repository;

//@Repository
//public class EmployeeRepo{
//
//    private final MongoTemplate mongoTemplate;
//
//    @Autowired
//    public EmployeeRepo(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    // Define repository methods
//}
