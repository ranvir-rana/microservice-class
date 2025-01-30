package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Car;

public interface CarMongoRepository extends CrudRepository<Car,String>{

}
