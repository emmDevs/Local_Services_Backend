package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Booking;
import com.example.LocalServices.models.Service;
import com.example.LocalServices.repositories.ServiceRepository;
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
public class ServiceController {

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
    ServiceRepository serviceRepository;

    @GetMapping(value = "/services")
    public ResponseEntity<List<Service>> getAllServices(){
        return new ResponseEntity(serviceRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/services/{id}")
    public ResponseEntity<Service> getService(@PathVariable Long id){
        return new ResponseEntity(serviceRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/services")
    public ResponseEntity<Service> postService(@RequestBody Service service){
        serviceRepository.save(service);
        return new ResponseEntity<>(service, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/services/{id}")
    public ResponseEntity<Long> deleteService(@PathVariable Long id){
        serviceRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value="/services/{id}")
    public ResponseEntity<Service> updateService(@RequestBody Service service, @PathVariable Long id){
        Service serviceToUpdate = serviceRepository.findById(id).get();
        serviceToUpdate.setName(service.getName());
        serviceToUpdate.setDescription(service.getDescription());
        serviceToUpdate.setPrice(service.getPrice());
        serviceToUpdate.setDuration(service.getDuration());
        serviceToUpdate.setCategories(service.getCategories());
        serviceToUpdate.setSlots(service.getSlots());
        serviceToUpdate.setBookings(service.getBookings());
        serviceToUpdate.setShop(service.getShop());
        serviceRepository.save(serviceToUpdate);
        return new ResponseEntity<>(serviceToUpdate, HttpStatus.OK);
    }

}
