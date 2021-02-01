package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JsonIgnoreProperties({"categories"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(
                            name="category_id",
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

    @ManyToMany
    @JsonIgnoreProperties({"categories"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(
                            name="category_id",
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

    public Category(){

    }

    public Category(String name, String description, String image){
        this.name = name;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
