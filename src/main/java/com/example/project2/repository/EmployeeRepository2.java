//package com.example.project2.repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.project2.model.Employee;
//
//@Repository
//public class EmployeeRepository2 {
//
//    private final MongoTemplate mongoTemplate;
//
//    @Autowired
//    public EmployeeRepository2(@Qualifier("mongoTemplate2") MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    public void save(Employee employee) {
//        mongoTemplate.save(employee); // Save the Employee object to the database
//    }
//    // Define repository methods
//}


//package com.example.project2.repository;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import com.example.project2.model.Employee;
//
//public interface EmployeeRepository2 extends MongoRepository<Employee, String>{
//
//}

package com.example.project2.repository;

import com.example.project2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository2 {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EmployeeRepository2(@Qualifier("mongoTemplate2") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Employee employee) {
        mongoTemplate.save(employee); // Save the Employee object to the database
    }
}







