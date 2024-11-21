package com.example.final_pract.repositories;

import com.example.final_pract.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
