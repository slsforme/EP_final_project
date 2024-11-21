package com.example.final_pract.repositories;

import com.example.final_pract.models.Dealers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealersRepository extends JpaRepository<Dealers, Integer> {
}
