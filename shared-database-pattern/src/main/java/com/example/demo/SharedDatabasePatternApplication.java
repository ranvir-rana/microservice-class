package com.example.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedDatabasePatternApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SharedDatabasePatternApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(SharedDatabasePatternApplication.class);
	
	@Autowired
	private BookRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("DB Application has started");
		repository.save(new Book("Javascript"));
		repository.save(new Book("Python"));
		repository.save(new Book("PySpark"));
		repository.save(new Book("PyTorch"));
		repository.save(new Book("Java"));
		repository.save(new Book("Scala"));
		repository.save(new Book("Golang"));
		repository.save(new Book("Erlang"));
		
		log.info("find all records");
		
		repository.findAll().forEach(x -> System.out.println(x));
		log.info("find by id records");
		
		repository.findById(8L).ifPresent(x -> System.out.println(x));
		
		log.info("find by name records");
		
		repository.findByName("Python").forEach(x -> System.out.println(x));
		
		/* log.info("delete by book id");
		Book bookToDelete = repository.findById(52L).get();
		
		System.out.println(bookToDelete.getName());
		repository.delete(bookToDelete); 
		*/
		
		/*
		log.info("delete book by title");
		repository.findByName("Java").forEach(book -> {
			System.out.println("deleting book :" + book.getName());
			repository.delete(book);
		});*/
		
		/* log.info("delete by book id");
		repository.deleteById(155L); */
		
		/* log.info("delete all by book id");
		repository.deleteAllById(Arrays.asList(203L,204L,209L,252L,253L)); */
		
		/* log.info("delete all by book name");
		repository.deleteAll(repository.findByName("JavaScript")); */
		
		log.info("find by sepecial name records");

		repository.findBySpecialBook("Java").forEach(x -> System.out.println(x));
		
		log.info("updating record");
		repository.findById(108L).ifPresent(x -> {
			System.out.println(x);
			x.setName("Scala - Spark");
			repository.save(x);
		});

	}

	
}
