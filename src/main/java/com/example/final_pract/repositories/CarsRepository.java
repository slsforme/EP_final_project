package com.example.final_pract.repositories;

import com.example.final_pract.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
