package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="postcode")
    private String postcode;

    @Column(name="town")
    private String town;

    @Column(name="opening_hour")
    private String openingHour;

    @Column(name="closing_hour")
    private String closingHour;

    @Column(name="telephone_number")
    private int telephoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="image")
    private String image;


    @ManyToMany
    @JsonIgnoreProperties({"shop"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "shops_categories",
            joinColumns = {
                    @JoinColumn(
                            name="shop_id",
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

    @ManyToMany
    @JsonIgnoreProperties({"shop"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "shops_services",
            joinColumns = {
                    @JoinColumn(
                            name="shop_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "service_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Service> services;

    public Shop(){

    }

    public Shop(String name, String address, String postcode, String town, String openingHour, String closingHour, int telephoneNumber, String email, String image){
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.town = town;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.image = image;
        this.categories = new ArrayList<Category>();
        this.services = new ArrayList<Service>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getOpening_hour() {
        return openingHour;
    }

    public void setOpening_hour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClosing_hour() {
        return closingHour;
    }

    public void setClosing_hour(String closingHour) {
        this.closingHour = closingHour;
    }

    public int getTelephone_number() {
        return telephoneNumber;
    }

    public void setTelephone_number(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void addService(Service service){
        this.services.add(service);
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
}
