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

        Shop shop1 = new Shop("Claire the Cobbler", "123 High Street", "EH42 1FA", "Dunbar", "0900", "1700", 01314761234, "claire@thecobblers.co.uk", "https://www.istockphoto.com/photo/craftsman-repairing-or-making-a-pair-of-shoes-gm1172791191-325501452?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&referrer_url=https%3A//pixabay.com/images/search/cobblers/&utm_term=cobblers");
        shopRepository.save(shop1);

        Shop shop2 = new Shop("Beauty from Above", "56 Market Street", "EH3 6HR", "Edinburgh", "1000", "1800", 01314761234, "beauty@theshop.com", "https://pixabay.com/photos/spa-salon-resort-oil-massage-2608450/");
        shopRepository.save(shop2);

        Service service1 = new Service("Shoe Repair", "one pair of shoes reheeled and resoled", 9.99, 60, shop1);
        serviceRepository.save(service1);

        Service service2 = new Service("Facial", "Relax in elegant surroundings and enjoy a rejuvinating facial made to match your skins needs", 30.00, 60, shop2);
        serviceRepository.save(service2);

        Service service3 = new Service("Manicure", "Choose from French Manicure or luxury hand massage and polish", 24.99, 30, shop2);
        serviceRepository.save(service3);

        Slot slot1 = new Slot(900, 1000, service1 );
        slotRepository.save(slot1);

        Slot slot2 = new Slot(1030, 1130, service1);
        slotRepository.save(slot2);

        Slot slot3 = new Slot(1200, 1300, service1);
        slotRepository.save(slot3);

        Slot slot4 = new Slot(1330, 1430, service1);
        slotRepository.save(slot4);

        Slot slot5 = new Slot(900, 1000, service2 );
        slotRepository.save(slot1);

        Slot slot6 = new Slot(1030, 1130, service2);
        slotRepository.save(slot2);

        Slot slot7 = new Slot(1200, 1300, service2);
        slotRepository.save(slot3);

        Slot slot8 = new Slot(1330, 1430, service2);
        slotRepository.save(slot4);

        Slot slot9 = new Slot(900, 1000, service3 );
        slotRepository.save(slot1);

        Slot slot10 = new Slot(1030, 1130, service3);
        slotRepository.save(slot2);

        Slot slot11 = new Slot(1200, 1300, service3);
        slotRepository.save(slot3);

        Slot slot12 = new Slot(1330, 1430, service3);
        slotRepository.save(slot4);

        User user1 = new User("Emma", "Hack", 21, "73 Beach Road", "EH42 7HG", "Dunbar", 01562310544, "emma@gmail.com", "ILoveCoding", false);
        userRepository.save(user1);

        User user2 = new User("Claire", "Smith", 35, "123 High Street", "EH42 1FA", "Dunbar", 01314761234, "claire@thecobblers.co.uk", "ILoveShoes", true);
        userRepository.save(user2);

        Booking booking1 = new Booking("2021-01-25", "2021-01-30", 1030, 1130, "1 pair of brown leather boots to be re- heeled and re-soled please", user1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("2021-01-05", "2021-02-06", 1300, 1430, "facial for dry skin and a luxury manicure please", user2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("2020-12-29", "2021-01-15", 1200, 1330, "french manicure", user1);
        bookingRepository.save(booking3);

        shop1.addService(service1);
        shop1.addCategory(category1);
        shopRepository.save(shop1);

        shop2.addService(service2);
        shop2.addService(service3);
        shop2.addCategory(category2);
        shopRepository.save(shop2);

        service1.addSlots(slot1);
        service1.addSlots(slot2);
        service1.addSlots(slot3);
        service1.addSlots(slot4);
        serviceRepository.save(service1);

        service2.addSlots(slot5);
        service2.addSlots(slot6);
        service2.addSlots(slot7);
        service2.addSlots(slot8);
        serviceRepository.save(service2);

        service3.addSlots(slot9);
        service3.addSlots(slot10);
        service3.addSlots(slot11);
        service3.addSlots(slot12);
        serviceRepository.save(service3);

        booking1.addService(service1);
        bookingRepository.save(booking1);

        booking2.addService(service2);
        booking2.addService(service3);
        bookingRepository.save(booking2);

        booking3.addService(service3);
        bookingRepository.save(booking3);

        user1.addBooking(booking1);
        user1.addBooking(booking3);
        userRepository.save(user1);

        user2.addBooking(booking2);
        userRepository.save(user2);











    }
}
