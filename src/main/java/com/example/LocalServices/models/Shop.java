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
    private String opening_hour;

    @Column(name="closing_hour")
    private String closing_hour;

    @Column(name="telephone_number")
    private int telephone_number;

    @Column(name="email")
    private String email;

    @Column(name="image")
    private String image;

    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties({"shop"})
    private List<Service> services;

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

    public Shop(){

    }

    public Shop(String name, String address, String postcode, String town, String opening_hour, String closing_hour, int telephone_number, String email, String image){
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.town = town;
        this.opening_hour = opening_hour;
        this.closing_hour = closing_hour;
        this.telephone_number = telephone_number;
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
        return opening_hour;
    }

    public void setOpening_hour(String opening_hour) {
        this.opening_hour = opening_hour;
    }

    public String getClosing_hour() {
        return closing_hour;
    }

    public void setClosing_hour(String closing_hour) {
        this.closing_hour = closing_hour;
    }

    public int getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(int telephone_number) {
        this.telephone_number = telephone_number;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
