package com.example.LocalServices.components;

import com.example.LocalServices.models.Category;
import com.example.LocalServices.models.Slot;
import com.example.LocalServices.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    SlotRepository slotRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Category category1 = new Category("Repair", "Damaged items can be mended", "https://pixabay.com/photos/shoemaking-shoe-shoemaker-human-3611509/");
        categoryRepository.save(category1);

        Category category2 = new Category("Beauty", "Pamper yourself", "https://pixabay.com/illustrations/massage-este-relax-relaxation-spa-1237913/");
        categoryRepository.save(category2);

        Slot slot1 = new Slot(12:00, );




    }
}
