package com.example.Paying_Guest.Accomdation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Paying_Guest.Accomdation.entities.PGPlace;
import com.example.Paying_Guest.Accomdation.repository.PGPlaceRepository;

@RestController
@RequestMapping("/api/pg")
public class PGController {
private final PGPlaceRepository repo;
public PGController(PGPlaceRepository repo) {
this.repo = repo;
}
@GetMapping("/city/{city}")
public List<PGPlace> getByCity(@PathVariable String city) {
return repo.findByCity(city);
}
@GetMapping("/locality/{locality}")
public List<PGPlace> getByLocality(@PathVariable String locality) {
return repo.findByLocality(locality);
}
@GetMapping("/{id}")
public PGPlace getById(@PathVariable Long id) {
return repo.findById(id).orElseThrow();
}
}
