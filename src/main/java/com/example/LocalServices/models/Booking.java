package com.example.LocalServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_booking_made")
    private Date date_booking_made;

    @Column(name="date_of_booking")
    private Date date_of_booking;

    @Column(name = "arrival_time")
    private Time arrival_time;

    @Column(name="departure_time")
    private Time departure_time;

    @Column(name="comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private User user;

    @ManyToOne
    @JoinColumn(name="service_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private Service service;

    public Booking(){

    }

    public Booking(Date date_booking_made, Date date_of_booking, Time arrival_time, Time departure_time, String comments, User user, Service service){
        this.date_booking_made = date_booking_made;
        this.date_of_booking = date_of_booking;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
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

    public Date getDate_booking_made() {
        return date_booking_made;
    }

    public void setDate_booking_made(Date date_booking_made) {
        this.date_booking_made = date_booking_made;
    }

    public Date getDate_of_booking() {
        return date_of_booking;
    }

    public void setDate_of_booking(Date date_of_booking) {
        this.date_of_booking = date_of_booking;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
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


}
