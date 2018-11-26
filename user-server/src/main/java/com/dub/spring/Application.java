package com.dub.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Application implements CommandLineRunner {

	@Autowired
	MongoTemplate primaryMongoTemplate;
	
	@Autowired
	MongoProperties mongoProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("database " 
				+ mongoProperties.getMongoClientDatabase());
		System.out.println("user " 
				+ mongoProperties.getUsername());//.getMongoClientDatabase());
		System.out.println("authentication database " 
				+ mongoProperties.getAuthenticationDatabase());//.getPassword().toString());//.getUsername());//.getMongoClientDatabase());
		System.out.println("host " 
				+ mongoProperties.getHost());//.getPassword().toString());//.getUsername());//.getMongoClientDatabase());
		System.out.println("port " 
				+ mongoProperties.getPort());//.getPassword().toString());//.getUsername());//.getMongoClientDatabase());
		System.out.println("MongoClientDatabase " 
				+ mongoProperties.getMongoClientDatabase());//.getPassword().toString());//.getUsername());//.getMongoClientDatabase());
		System.out.println("URI " 
				+ mongoProperties.getUri());//.getMongoClientDatabase());//.getPassword().toString());//.getUsername());//.getMongoClientDatabase());
			
		System.out.println("run completed");
		
	}
}
