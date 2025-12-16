package com.example.Paying_Guest.Accomdation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Paying_Guest.Accomdation.entities.Tenant;


public interface TenantRepository extends JpaRepository<Tenant, Long> {}
