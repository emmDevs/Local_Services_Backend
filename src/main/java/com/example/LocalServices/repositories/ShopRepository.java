package com.example.LocalServices.repositories;

import com.example.LocalServices.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
