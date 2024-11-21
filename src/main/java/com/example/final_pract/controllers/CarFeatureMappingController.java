package com.example.final_pract.controllers;

import com.example.final_pract.models.CarFeatureMapping;
import com.example.final_pract.repositories.CarFeatureMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carFeatureMapping")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarFeatureMappingController {

    @Autowired
    private CarFeatureMappingRepository carFeatureMappingRepository;

    @GetMapping
    public List<CarFeatureMapping> getAllCarFeatureMappings() {
        return carFeatureMappingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarFeatureMapping> getCarFeatureMappingById(@PathVariable Integer id) {
        Optional<CarFeatureMapping> carFeatureMapping = carFeatureMappingRepository.findById(id);
        return carFeatureMapping.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarFeatureMapping createCarFeatureMapping(@RequestBody CarFeatureMapping carFeatureMapping) {
        return carFeatureMappingRepository.save(carFeatureMapping);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarFeatureMapping> updateCarFeatureMapping(@PathVariable Integer id, @RequestBody CarFeatureMapping carFeatureMappingDetails) {
        Optional<CarFeatureMapping> existingCarFeatureMapping = carFeatureMappingRepository.findById(id);
        if (existingCarFeatureMapping.isPresent()) {
            CarFeatureMapping carFeatureMapping = existingCarFeatureMapping.get();
            carFeatureMapping.setFeature(carFeatureMappingDetails.getFeature());
            carFeatureMapping.setCar(carFeatureMappingDetails.getCar());
            return ResponseEntity.ok(carFeatureMappingRepository.save(carFeatureMapping));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarFeatureMapping(@PathVariable Integer id) {
        Optional<CarFeatureMapping> carFeatureMapping = carFeatureMappingRepository.findById(id);
        if (carFeatureMapping.isPresent()) {
            carFeatureMappingRepository.delete(carFeatureMapping.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
