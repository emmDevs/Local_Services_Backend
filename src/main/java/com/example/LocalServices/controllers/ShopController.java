package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Shop;
import com.example.LocalServices.repositories.ServiceRepository;
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
    public ResponseEntity<List<Shop>> getAllShops(){
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

}
