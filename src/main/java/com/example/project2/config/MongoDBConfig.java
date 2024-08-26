//package com.example.project2.config;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//public class MongoDBConfig {
//
//    @Value("${spring.data.mongodb.uri}")
//    private String mongoUri;
//
//    @Value("${spring.data.mongodb.database2.uri}")
//    private String mongoUri2;
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create(mongoUri);
//    }
//
//    @Bean(name = "mongoTemplate")
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), "EmployeeDatabase");
//    }
//
//    @Bean(name = "mongoTemplate2")
//    public MongoTemplate mongoTemplate2() {
//        return new MongoTemplate(MongoClients.create(mongoUri2), "EmployeeDatabase2");
//    }
//}

package com.example.project2.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database2.uri}")
    private String mongoUri2;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create(mongoUri), "EmployeeDatabase");
    }

    @Bean(name = "mongoTemplate2")
    public MongoTemplate mongoTemplate2() {
        return new MongoTemplate(MongoClients.create(mongoUri2), "EmployeeDatabase2");
    }
}

