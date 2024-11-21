package com.example.final_pract.repositories;

import com.example.final_pract.models.CarFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFeaturesRepository extends JpaRepository<CarFeatures, Integer> {
}
