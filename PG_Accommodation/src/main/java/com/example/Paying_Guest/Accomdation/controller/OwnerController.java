package com.example.Paying_Guest.Accomdation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Paying_Guest.Accomdation.entities.Owner;
import com.example.Paying_Guest.Accomdation.entities.PGPlace;
import com.example.Paying_Guest.Accomdation.repository.OwnerRepository;
import com.example.Paying_Guest.Accomdation.repository.PGPlaceRepository;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
private final PGPlaceRepository pgRepo;
private final OwnerRepository ownerRepo;

public OwnerController(PGPlaceRepository pgRepo, OwnerRepository
ownerRepo) {
this.pgRepo = pgRepo;
this.ownerRepo = ownerRepo;
}

// add pg
@PostMapping("/{ownerId}/places")
public PGPlace addPlace(@PathVariable Long ownerId, @RequestBody PGPlace pg) {
Owner owner = ownerRepo.findById(ownerId).orElseThrow();
pg.setOwner(owner);
return pgRepo.save(pg);
}
@GetMapping("/{ownerId}/places")
public List<PGPlace> getPlacesByOwner(@PathVariable Long ownerId) {
Owner owner = ownerRepo.findById(ownerId).orElseThrow();
return owner.getPgPlaces();
}
@PutMapping("/places/{id}")
public PGPlace updatePG(@PathVariable Long id, @RequestBody PGPlace pg) {
PGPlace existing = pgRepo.findById(id).orElseThrow();
existing.setPgName(pg.getPgName());
existing.setCity(pg.getCity());
existing.setLocality(pg.getLocality());
existing.setRentAmount(pg.getRentAmount());
existing.setAvailable(pg.isAvailable());
return pgRepo.save(existing);
}
@PutMapping("/places/{id}/availability")
public PGPlace changeAvailability(@PathVariable Long id, @RequestParam
boolean available) {
PGPlace pg = pgRepo.findById(id).orElseThrow();
pg.setAvailable(available);
return pgRepo.save(pg);
}
@DeleteMapping("/places/{id}")
public void deletePG(@PathVariable Long id) {
pgRepo.deleteById(id);
}
}
