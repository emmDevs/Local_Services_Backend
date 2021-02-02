package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Shop;
import com.example.LocalServices.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ShopController {

    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            AntPathMatcher matcher = new AntPathMatcher();
            matcher.setCaseSensitive(false);
            configurer.setPathMatcher(matcher);
        }
    }

    @Autowired
    ShopRepository shopRepository;

    @GetMapping(value = "/shops")
    public ResponseEntity getAllShopsAndFilters(
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "categoryName") String categoryName,
            @RequestParam(required = false, name = "name") String shopName

    ){
        if(town != null){
            return new ResponseEntity<>(shopRepository.findByTownIgnoreCase(town), HttpStatus.OK);
        }

        if(categoryName != null){
            return new ResponseEntity(shopRepository.findByCategoriesNameIgnoreCase(categoryName), HttpStatus.OK);
        }

        if(shopName != null){
            return new ResponseEntity(shopRepository.findByNameIgnoreCase(shopName), HttpStatus.OK);
        }

        return new ResponseEntity(shopRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/shops/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id){
        return new ResponseEntity(shopRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/shops")
    public ResponseEntity<Shop> postShop(@RequestBody Shop shop){
        shopRepository.save(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/shops/{id}")
    public ResponseEntity<Long> deleteShop(@PathVariable Long id){
        shopRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/shops/{id}")
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop, @PathVariable Long id){
        Shop shopToUpdate = shopRepository.findById(id).get();
        shopToUpdate.setName(shop.getName());
        shopToUpdate.setAddress(shop.getAddress());
        shopToUpdate.setPostcode(shop.getPostcode());
        shopToUpdate.setTown(shop.getTown());
        shopToUpdate.setOpeningHour(shop.getOpeningHour());
        shopToUpdate.setClosingHour(shop.getClosingHour());
        shopToUpdate.setTelephoneNumber(shop.getTelephoneNumber());
        shopToUpdate.setEmail(shop.getEmail());
        shopToUpdate.setImage(shop.getImage());
        shopRepository.save(shopToUpdate);
        return new ResponseEntity<>(shopToUpdate, HttpStatus.OK);
    }

}
