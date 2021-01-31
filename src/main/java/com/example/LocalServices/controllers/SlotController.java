package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Slot;
import com.example.LocalServices.models.User;
import com.example.LocalServices.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class SlotController {

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
    SlotRepository slotRepository;

    @GetMapping(value = "/slots")
    public ResponseEntity<List<Slot>> getAllSlots(){
        return new ResponseEntity(slotRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/slots/{id}")
    public ResponseEntity<Slot> getSlot(@PathVariable Long id){
        return new ResponseEntity(slotRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/slots")
    public ResponseEntity<Slot> postSlot(@RequestBody Slot slot){
        slotRepository.save(slot);
        return new ResponseEntity<>(slot, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/slots/{id}")
    public ResponseEntity<Long> deleteSlot(@PathVariable Long id){
        slotRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value ="/slots/{id}")
    public ResponseEntity<Slot> updateSlot(@RequestBody Slot slot, @PathVariable Long id){
        Slot slotToUpdate = slotRepository.findById(id).get();
        slotToUpdate.setStartTime(slot.getStartTime());
        slotToUpdate.setEndTime(slot.getEndTime());
        slotRepository.save(slotToUpdate);
        return new ResponseEntity<>(slotToUpdate, HttpStatus.OK);
    }

}
