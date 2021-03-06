package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="duration")
    private int duration;

    @JsonIgnoreProperties({"service"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy="service")
    private List<Booking> bookings;

    @JsonIgnoreProperties({"services"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "service_categories",
            joinColumns = {
                    @JoinColumn(
                            name="service_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "category_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Category> categories;


    @JsonIgnoreProperties({"service"})
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "service")
    private List<Slot> slots;

    @JsonIgnoreProperties({"services"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "service_shops",
            joinColumns = {
                    @JoinColumn(
                            name="service_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "shop_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Shop> shops;

    public Service(){

    }

    public Service(String name, String description, double price, int duration){
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.categories = new ArrayList<Category>();
        this.slots = new ArrayList<Slot>();
        this.bookings = new ArrayList<Booking>();
        this.shops = new ArrayList<Shop>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlots(Slot slot){
        this.slots.add(slot);
    }


    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
