package com.example.final_pract.controllers;

import com.example.final_pract.models.CarFeatures;
import com.example.final_pract.repositories.CarFeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carFeatures")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarFeaturesController {

    @Autowired
    private CarFeaturesRepository carFeaturesRepository;

    @GetMapping
    public List<CarFeatures> getAllCarFeatures() {
        return carFeaturesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarFeatures> getCarFeatureById(@PathVariable Integer id) {
        Optional<CarFeatures> carFeature = carFeaturesRepository.findById(id);
        return carFeature.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarFeatures createCarFeature(@RequestBody CarFeatures carFeature) {
        return carFeaturesRepository.save(carFeature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarFeatures> updateCarFeature(@PathVariable Integer id, @RequestBody CarFeatures carFeatureDetails) {
        Optional<CarFeatures> existingCarFeature = carFeaturesRepository.findById(id);
        if (existingCarFeature.isPresent()) {
            CarFeatures carFeature = existingCarFeature.get();
            carFeature.setName(carFeatureDetails.getName());
            return ResponseEntity.ok(carFeaturesRepository.save(carFeature));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarFeature(@PathVariable Integer id) {
        Optional<CarFeatures> carFeature = carFeaturesRepository.findById(id);
        if (carFeature.isPresent()) {
            carFeaturesRepository.delete(carFeature.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
