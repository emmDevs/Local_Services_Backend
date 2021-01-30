package com.example.LocalServices.repositories;

import com.example.LocalServices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<User, Long> {
}
