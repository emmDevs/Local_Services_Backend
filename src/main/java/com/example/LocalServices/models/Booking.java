package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_booking_made")
    private LocalDate dateBookingMade;

    @Column(name="date_of_booking")
    private LocalDate dateOfBooking;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name="departure_time")
    private LocalTime departureTime;

    @Column(name="comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private User user;

    @ManyToMany
    @JsonIgnoreProperties({"bookings"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "bookings_services",
            joinColumns = {
                    @JoinColumn(
                            name = "booking_id",
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


    public Booking(){

    }

    public Booking(LocalDate dateBookingMade, LocalDate dateOfBooking, LocalTime arrivalTime, LocalTime departureTime, String comments, User user){
        this.dateBookingMade = dateBookingMade;
        this.dateOfBooking = dateOfBooking;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.comments = comments;
        this.user = user;
        this.services = new ArrayList<Service>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_booking_made() {
        return dateBookingMade;
    }

    public void setDate_booking_made(LocalDate dateBookingMade) {
        this.dateBookingMade = dateBookingMade;
    }

    public LocalDate getDate_of_booking() {
        return dateOfBooking;
    }

    public void setDate_of_booking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalTime getArrival_time() {
        return arrivalTime;
    }

    public void setArrival_time(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDeparture_time() {
        return departureTime;
    }

    public void setDeparture_time(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
