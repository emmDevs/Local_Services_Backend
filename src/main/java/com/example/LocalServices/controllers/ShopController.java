package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Category;
import com.example.LocalServices.models.Service;
import com.example.LocalServices.models.Shop;
import com.example.LocalServices.repositories.CategoryRepository;
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

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

//    Handle routes and filters:
//    GET /shops
//    GET /shops?name
//    GET /shops?town
//    GET /shops?categoryName
//    GET /shops?serviceName
//    @return `ResponseEntity<List<Shop>>`

    @GetMapping(value = "/shops")
    public ResponseEntity getAllShopsAndFilters(
            @RequestParam(required = false, name = "name") String shopName,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "categoryName") String categoryName,
            @RequestParam(required = false, name = "serviceName") String serviceName

    ){
        if(shopName != null){
            return new ResponseEntity(shopRepository.findByNameIgnoreCase(shopName), HttpStatus.OK);
        }

        if(town != null){
            return new ResponseEntity<>(shopRepository.findByTownIgnoreCase(town), HttpStatus.OK);
        }

        if(categoryName != null){
            return new ResponseEntity(shopRepository.findByCategoriesNameIgnoreCase(categoryName), HttpStatus.OK);
        }

        if(serviceName != null){
            return new ResponseEntity(shopRepository.findByServicesNameIgnoreCase(serviceName), HttpStatus.OK);
        }

        return new ResponseEntity(shopRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/shops/{id}")
    public ResponseEntity getShop(@PathVariable Long id){
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
        shopToUpdate.setCategories(shop.getCategories());
        shopToUpdate.setServices(shop.getServices());
        shopRepository.save(shopToUpdate);
        return new ResponseEntity<>(shopToUpdate, HttpStatus.OK);
    }

//    PATCH /shops/{id}?address=name
//    PATCH /shops/{id}?hours=name
//    PATCH /shops/{id}?category=
//    PATCH /shops/{id}?service=

    @PatchMapping(value = "/shops/{id}")
    public ResponseEntity<Shop> patchShopCategory(
            @PathVariable Long id,
            @RequestBody(required = false) Shop shop,
            @RequestParam(required = false, name = "address") String address,
            @RequestParam(required = false, name = "hours") String hours,
            @RequestParam(required = false, name = "phone") String phone,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "category") Long categoryId,
            @RequestParam(required = false, name = "service") Long serviceId
    ){
        Shop shopToPatch = shopRepository.findById(id).get();

        if(address != null && shop != null){
            shopToPatch.setAddress(shop.getAddress());
            shopToPatch.setPostcode(shop.getPostcode());
            shopToPatch.setTown(shop.getTown());
        }

        if(hours != null && shop != null){
            shopToPatch.setOpeningHour(shop.getOpeningHour());
            shopToPatch.setClosingHour(shop.getClosingHour());
        }

        if(phone != null && shop != null){
            shopToPatch.setTelephoneNumber(shop.getTelephoneNumber());
        }

        if(email != null && shop != null){
            shopToPatch.setEmail(shop.getEmail());
        }

        if(categoryId != null){
            Category category = categoryRepository.findById(categoryId).get();
            shopToPatch.addCategory(category);
        }

        if(serviceId != null){
            Service service = serviceRepository.findById(serviceId).get();
            shopToPatch.addService(service);
        }

        shopRepository.save(shopToPatch);
        return  new ResponseEntity<>(shopToPatch, HttpStatus.OK);
    }
}
