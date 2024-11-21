package com.example.final_pract.controllers;


import com.example.final_pract.models.Dealers;
import com.example.final_pract.repositories.DealersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dealers")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DealersController {

    @Autowired
    private DealersRepository dealersRepository;

    @GetMapping
    public List<Dealers> getAllDealers() {
        return dealersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealers> getDealerById(@PathVariable Integer id) {
        Optional<Dealers> dealer = dealersRepository.findById(id);
        return dealer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dealers createDealer(@RequestBody Dealers dealer) {
        return dealersRepository.save(dealer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealers> updateDealer(@PathVariable Integer id, @RequestBody Dealers dealerDetails) {
        Optional<Dealers> existingDealer = dealersRepository.findById(id);
        if (existingDealer.isPresent()) {
            Dealers dealer = existingDealer.get();
            dealer.setName(dealerDetails.getName());
            dealer.setContactNumber(dealerDetails.getContactNumber());
            return ResponseEntity.ok(dealersRepository.save(dealer));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Integer id) {
        Optional<Dealers> dealer = dealersRepository.findById(id);
        if (dealer.isPresent()) {
            dealersRepository.delete(dealer.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
