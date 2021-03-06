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

    @Column(name="dateOfBooking")
    private LocalDate dateOfBooking;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name="departure_time")
    private LocalTime departureTime;

    @Column(name="comments")
    private String comments;

    @JsonIgnoreProperties({"bookings"})
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @JsonIgnoreProperties({"bookings"})
    @ManyToOne
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name ="service_id", nullable = false)
    private Service service;


    public Booking(){

    }

    public Booking(LocalDate dateBookingMade, LocalDate dateOfBooking, LocalTime arrivalTime, LocalTime departureTime, String comments, User user, Service service){
        this.dateBookingMade = dateBookingMade;
        this.dateOfBooking = dateOfBooking;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.comments = comments;
        this.user = user;
        this.service = service;
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


    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

//    public void addService(Service service){
//        this.services.add(service);
//    }
}
