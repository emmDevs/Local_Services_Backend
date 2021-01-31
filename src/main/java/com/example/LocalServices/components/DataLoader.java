package com.example.LocalServices.components;

import com.example.LocalServices.models.*;
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

       Shop shop1 = new Shop("Claire the Cobbler", "123 High Street", "EH42 1FA", "Dunbar", "0900", "1700", 01314761234, "claire@thecobblers.co.uk", "https://www.istockphoto.com/photo/craftsman-repairing-or-making-a-pair-of-shoes-gm1172791191-325501452?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&referrer_url=https%3A//pixabay.com/images/search/cobblers/&utm_term=cobblers");
       shopRepository.save(shop1);

       Shop shop2 = new Shop("Beauty from Above", "56 Market Street", "EH3 6HR", "Edinburgh", "1000", "1800", 01316549876, "beauty@theshop.com", "https://pixabay.com/photos/spa-salon-resort-oil-massage-2608450/");
       shopRepository.save(shop2);

       Service service1 = new Service("Shoe Repair", "one pair of shoes reheeled and resoled", 9.99, 60, shop1);
       serviceRepository.save(service1);

       Service service2 = new Service("Facial", "Relax in elegant surroundings and enjoy a rejuvinating facial made to match your skins needs", 30.00, 60, shop2);
       serviceRepository.save(service2);

       User user1 = new User("Emma", "Hack", 21, "73 Beach Road", "EH42 7HG", "Dunbar", 01562310544, "emma@gmail.com", "ILoveCoding", false);
       userRepository.save(user1);

       User user2 = new User("Claire", "Smith", 35, "123 High Street", "EH42 1FA", "Dunbar", 01314761234, "claire@thecobblers.co.uk", "ILoveShoes", true);
       userRepository.save(user2);

       Booking booking1 = new Booking(2021-01-25, )









    }
}
