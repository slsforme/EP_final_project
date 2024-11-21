package com.example.final_pract.repositories;

import com.example.final_pract.models.ServiceRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordsRepository extends JpaRepository<ServiceRecords, Integer> {
}
