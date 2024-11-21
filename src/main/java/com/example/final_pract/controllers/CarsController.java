package com.example.final_pract.controllers;

import com.example.final_pract.models.Cars;
import com.example.final_pract.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarsController {

    @Autowired
    private CarsRepository carsRepository;

    // 1. Получить все машины
    @GetMapping
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

    // 2. Получить машину по ID
    @GetMapping("/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable Integer id) {
        return carsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Создать новую машину
    @PostMapping
    public Cars createCar(@RequestBody Cars car) {
        return carsRepository.save(car);
    }

    // 4. Обновить машину
    @PutMapping("/{id}")
    public ResponseEntity<Cars> updateCar(@PathVariable Integer id, @RequestBody Cars carDetails) {
        return carsRepository.findById(id).map(car -> {
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setPrice(carDetails.getPrice());
            car.setDealer(carDetails.getDealer());
            carsRepository.save(car);
            return ResponseEntity.ok(car);
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. Удалить машину
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Integer id) {
        return carsRepository.findById(id).map(car -> {
            carsRepository.delete(car);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

