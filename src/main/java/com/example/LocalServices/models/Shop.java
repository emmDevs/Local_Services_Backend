package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
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
    private Time opening_hour;

    @Column(name="closing_hour")
    private Time closing_hour;

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
    @JsonIgnoreProperties({"service"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "services_categories",
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






}
