package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByName(String name);
	
	@Query("SELECT u FROM Book u WHERE u.name = :name")
	List<Book> findBySpecialBook(String name);
	
	
	
}
