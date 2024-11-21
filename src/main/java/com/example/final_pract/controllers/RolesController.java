package com.example.final_pract.controllers;

import com.example.final_pract.models.Roles;
import com.example.final_pract.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Integer id) {
        Optional<Roles> role = rolesRepository.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles role) {
        return rolesRepository.save(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Integer id, @RequestBody Roles roleDetails) {
        Optional<Roles> existingRole = rolesRepository.findById(id);
        if (existingRole.isPresent()) {
            Roles role = existingRole.get();
            role.setName(roleDetails.getName());
            role.setDescription(roleDetails.getDescription());
            return ResponseEntity.ok(rolesRepository.save(role));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        Optional<Roles> role = rolesRepository.findById(id);
        if (role.isPresent()) {
            rolesRepository.delete(role.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
