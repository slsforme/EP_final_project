package com.example.final_pract.controllers;

import com.example.final_pract.models.ServiceRecords;
import com.example.final_pract.repositories.ServiceRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/service_records")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ServiceRecordsController {

    @Autowired
    private ServiceRecordsRepository serviceRecordsRepository;

    @GetMapping
    public List<ServiceRecords> getAllServiceRecords() {
        return serviceRecordsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRecords> getServiceRecordById(@PathVariable Integer id) {
        Optional<ServiceRecords> serviceRecord = serviceRecordsRepository.findById(id);
        return serviceRecord.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServiceRecords createServiceRecord(@RequestBody ServiceRecords serviceRecord) {
        return serviceRecordsRepository.save(serviceRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRecords> updateServiceRecord(@PathVariable Integer id, @RequestBody ServiceRecords serviceRecordDetails) {
        Optional<ServiceRecords> existingServiceRecord = serviceRecordsRepository.findById(id);
        if (existingServiceRecord.isPresent()) {
            ServiceRecords serviceRecord = existingServiceRecord.get();
            serviceRecord.setCar(serviceRecordDetails.getCar());
            serviceRecord.setServiceDate(serviceRecordDetails.getServiceDate());
            serviceRecord.setDescription(serviceRecordDetails.getDescription());
            serviceRecord.setCost(serviceRecordDetails.getCost());
            return ResponseEntity.ok(serviceRecordsRepository.save(serviceRecord));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRecord(@PathVariable Integer id) {
        Optional<ServiceRecords> serviceRecord = serviceRecordsRepository.findById(id);
        if (serviceRecord.isPresent()) {
            serviceRecordsRepository.delete(serviceRecord.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
