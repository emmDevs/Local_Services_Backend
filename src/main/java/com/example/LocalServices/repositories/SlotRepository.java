package com.example.LocalServices.repositories;

import com.example.LocalServices.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
}
