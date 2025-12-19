package com.example.Paying_Guest.Accomdation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Paying_Guest.Accomdation.entities.PGPlace;

import java.util.List;
public interface PGPlaceRepository extends JpaRepository<PGPlace, Long> {
List<PGPlace> findByCity(String city);
List<PGPlace> findByLocality(String locality);
}

