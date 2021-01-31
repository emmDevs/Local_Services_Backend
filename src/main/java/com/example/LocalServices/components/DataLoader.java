package com.example.LocalServices.components;

import com.example.LocalServices.models.Category;
import com.example.LocalServices.models.Shop;
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

       Slot slot1 = new Slot(900, 1000);
       slotRepository.save(slot1);

       Slot slot2 = new Slot(1030, 1130);
       slotRepository.save(slot2);

       Slot slot3 = new Slot(1200, 1300);
       slotRepository.save(slot3);

       Slot slot4 = new Slot(1330, 1430);
       slotRepository.save(slot4);

        Shop shop1 = new Shop("Claire the Cobbler", "123 High Street", "EH42 1FA", "Dunbar", )








    }
}
