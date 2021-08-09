package com.example.sweater;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.CarRepository;
import com.example.sweater.domain.Owner;
import com.example.sweater.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SweaterApplication {
    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;
    public static void main(String[] args) {
        SpringApplication.run(SweaterApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            orepository.save(owner1);
            orepository.save(owner2);

            repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
            repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
        };
    }

}
