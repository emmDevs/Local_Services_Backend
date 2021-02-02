package com.example.LocalServices.repositories;

import com.example.LocalServices.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByTownIgnoreCase(String town);

    List<Shop> findByCategoriesNameIgnoreCase(String name);

    List<Shop> findByNameIgnoreCase(String name);


}
