package com.example.demo.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{
	
	

}
