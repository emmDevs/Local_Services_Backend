package com.example.LocalServices.components;

import com.example.LocalServices.models.*;
import com.example.LocalServices.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

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

        Category category1 = new Category("Repair", "Damaged items can be mended", "http://localhost:8080/repairCategory.jpg");
        categoryRepository.save(category1);

        Category category2 = new Category("Beauty", "Pamper yourself", "http://localhost:8080/beautyCategory.jpeg");
        categoryRepository.save(category2);

        Category category3 = new Category("Health and Wellbeing", "Look after you", "http://localhost:8080/healthAndWellbeingCategory.png");
        categoryRepository.save(category3);

        Category category4 = new Category("Art", "All things art related", "http://localhost:8080/artCategory.jpg");
        categoryRepository.save(category4);

        Shop shop1 = new Shop("Claire the Cobbler", "123 High Street", "EH42 1FA", "Dunbar", LocalTime.parse("09:00"), LocalTime.parse("17:00"), "01314761234", "claire@thecobblers.co.uk", "http://localhost:8080/cobbler.jpg");
        shopRepository.save(shop1);

        Shop shop2 = new Shop("The Beauty Room", "56 Market Street", "EH3 6HR", "Edinburgh", LocalTime.parse("10:00"), LocalTime.parse("18:00"), "01314761234", "beauty@theshop.com", "http://localhost:8080/beautician.jpg");
        shopRepository.save(shop2);

        Shop shop3 = new Shop("The Kinsman", "12 Church Street", "EH3 6HR", "Edinburgh", LocalTime.parse("10:00"), LocalTime.parse("16:00"), "0013686523778", "info@KinsmanBarbers.com", "http://localhost:8080/barbers.jpg");
        shopRepository.save(shop3);

        Shop shop4 = new Shop("PedalWorks", "38 Quayside", "EH12 5RD", "Edinburgh", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01319823716", "hello@pedalworks.com", "http://localhost:8080/bikeshop.jpeg");
        shopRepository.save(shop4);

        Shop shop5 = new Shop("Star Dry Cleaners & Alterations", "38 Church Street", "EH3 6HR", "Edinburgh", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01316665242", "StarDryCleaners@gmail.com", "http://localhost:8080/drycleaners.jpeg");
        shopRepository.save(shop5);

        Shop shop6 = new Shop("Noa Nailbar & Lounge", "27 West Road", "EH45 6RE", "Edinburgh", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01316784356", "NoaNailBar@yahoo.com", "http://localhost:8080/nailbar.jpg");
        shopRepository.save(shop6);

        Shop shop7 = new Shop("Pete's Personal Training", "5 Beach Lane", "EH42 1FA", "Dunbar", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01368876445", "Petethepersonaltrainer@gmail.com", "http://localhost:8080/personalTrainer.jpeg");
        shopRepository.save(shop7);

        Shop shop8 = new Shop("Wallspace", "2 Quayside", "EH12 5RD",  "Dunbar", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01318923455", "info@wallspace.co.uk", "http://localhost:8080/pictureFramer.jpeg");
        shopRepository.save(shop8);

        Shop shop9 = new Shop("True Love", "75 High Street", "EH32 6TG",  "Dunbar", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "01368733458", "tattoo@truelove.co.uk", "http://localhost:8080/tattooParlour.jpeg");
        shopRepository.save(shop9);

        Shop shop10 = new Shop("Klaire's Kundalini Space", "7 Beach Lane", "EH42 1FA",  "Dunbar", LocalTime.parse("08:00"), LocalTime.parse("17:00"), "07993436271", "kundaliniklaire@gmail.com", "http://localhost:8080/yogaStudio.jpeg");
        shopRepository.save(shop10);

        Service service1 = new Service("Shoe Repair", "one pair of shoes reheeled and resoled", 9.99, 60, shop1);
        serviceRepository.save(service1);

        Service service2 = new Service("Facial", "Relax in elegant surroundings and enjoy a rejuvinating facial made to match your skins needs", 30.00, 60, shop2);
        serviceRepository.save(service2);

        Service service3 = new Service("Manicure", "Choose from French Manicure or luxury hand massage and polish", 24.99, 30, shop2);
        serviceRepository.save(service3);

        Slot slot1 = new Slot(LocalTime.parse("09:00"), LocalTime.parse("10:00"), service1);
        slotRepository.save(slot1);

        Slot slot2 = new Slot(LocalTime.parse("10:30"), LocalTime.parse("11:30"), service1);
        slotRepository.save(slot2);

        Slot slot3 = new Slot(LocalTime.parse("12:00"), LocalTime.parse("13:00"), service1);
        slotRepository.save(slot3);

        Slot slot4 = new Slot(LocalTime.parse("13:30"), LocalTime.parse("14:30"), service1);
        slotRepository.save(slot4);

        Slot slot5 = new Slot(LocalTime.parse("09:00"), LocalTime.parse("10:00"), service2 );
        slotRepository.save(slot5);

        Slot slot6 = new Slot(LocalTime.parse("10:30"), LocalTime.parse("11:30"), service2);
        slotRepository.save(slot6);

        Slot slot7 = new Slot(LocalTime.parse("12:00"), LocalTime.parse("13:00"), service2);
        slotRepository.save(slot7);

        Slot slot8 = new Slot(LocalTime.parse("13:30"), LocalTime.parse("14:30"), service2);
        slotRepository.save(slot8);

        Slot slot9 = new Slot(LocalTime.parse("09:00"), LocalTime.parse("10:00"), service3 );
        slotRepository.save(slot9);

        Slot slot10 = new Slot(LocalTime.parse("10:30"), LocalTime.parse("11:30"), service3);
        slotRepository.save(slot10);

        Slot slot11 = new Slot(LocalTime.parse("12:00"), LocalTime.parse("13:00"), service3);
        slotRepository.save(slot11);

        Slot slot12 = new Slot(LocalTime.parse("13:30"), LocalTime.parse("14:30"), service3);
        slotRepository.save(slot12);

        User user1 = new User("Emma", "Hack", 21, "73 Beach Road", "EH42 7HG", "Dunbar", "01562310544", "emma@gmail.com", "ILoveCoding", false);
        userRepository.save(user1);

        User user2 = new User("Claire", "Smith", 35, "123 High Street", "EH42 1FA", "Dunbar", "01314761234", "claire@thecobblers.co.uk", "ILoveShoes", true);
        userRepository.save(user2);

        Booking booking1 = new Booking(LocalDate.parse("2021-01-15"), LocalDate.parse("2021-01-30"), LocalTime.parse("10:30"), LocalTime.parse("11:30"), "1 pair of brown leather boots to be re- heeled and re-soled please", user1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(LocalDate.parse("2021-01-05"), LocalDate.parse("2021-02-06"), LocalTime.parse("13:00"), LocalTime.parse("14:30"), "facial for dry skin and a luxury manicure please", user2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(LocalDate.parse("2020-12-29"),LocalDate.parse("2021-01-15"),LocalTime.parse("12:00"), LocalTime.parse("13:30"), "french manicure", user1);
        bookingRepository.save(booking3);

        shop1.addService(service1);
        shop1.addCategory(category1);
        shopRepository.save(shop1);

        shop2.addService(service2);
        shop2.addService(service3);
        shop2.addCategory(category2);
        shopRepository.save(shop2);

        shop3.addCategory(category2);
        shop3.addCategory(category3);
        shopRepository.save(shop3);

        shop4.addCategory(category1);
        shopRepository.save(shop4);

        shop5.addCategory(category1);
        shopRepository.save(shop5);

        shop6.addCategory(category2);
        shop6.addCategory(category3);
        shopRepository.save(shop6);

        shop7.addCategory(category3);
        shopRepository.save(shop7);

        shop8.addCategory(category1);
        shop8.addCategory(category4);
        shopRepository.save(shop8);

        shop9.addCategory(category2);
        shop9.addCategory(category4);
        shopRepository.save(shop9);

        shop10.addCategory(category3);
        shopRepository.save(shop10);

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

//        booking1.addService(service1);
//        bookingRepository.save(booking1);
//
//        booking2.addService(service2);
//        booking2.addService(service3);
//        bookingRepository.save(booking2);
//
//        booking3.addService(service3);
//        bookingRepository.save(booking3);
//
//        user1.addBooking(booking1);
//        user1.addBooking(booking3);
//        userRepository.save(user1);
//
//        user2.addBooking(booking2);
//        userRepository.save(user2);











    }
}
