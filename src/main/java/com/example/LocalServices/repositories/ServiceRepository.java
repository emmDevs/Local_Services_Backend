package com.example.LocalServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LocalServices.models.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
