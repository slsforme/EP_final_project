package com.example.final_pract.repositories;

import com.example.final_pract.models.CarFeatureMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFeatureMappingRepository extends JpaRepository<CarFeatureMapping, Integer> {
}
