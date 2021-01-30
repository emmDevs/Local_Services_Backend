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

    @Column(name = arrival_time)
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




}
