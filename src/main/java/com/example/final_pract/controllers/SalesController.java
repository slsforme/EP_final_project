package com.example.final_pract.controllers;

import com.example.final_pract.models.Sales;
import com.example.final_pract.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sales")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Integer id) {
        Optional<Sales> sale = salesRepository.findById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sales createSale(@RequestBody Sales sale) {
        return salesRepository.save(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSale(@PathVariable Integer id, @RequestBody Sales saleDetails) {
        Optional<Sales> existingSale = salesRepository.findById(id);
        if (existingSale.isPresent()) {
            Sales sale = existingSale.get();
            sale.setCar(saleDetails.getCar());
            sale.setCustomer(saleDetails.getCustomer());
            sale.setDealer(saleDetails.getDealer());
            sale.setSaleDate(saleDetails.getSaleDate());
            sale.setFinalPrice(saleDetails.getFinalPrice());
            return ResponseEntity.ok(salesRepository.save(sale));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        Optional<Sales> sale = salesRepository.findById(id);
        if (sale.isPresent()) {
            salesRepository.delete(sale.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
