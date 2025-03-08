package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "Appointment" )
public class Appointment {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String email;
    private String faculty;
    private String lecturer;
    private String message;
    private String count;
    private String status;
    private String date;
    private String assignDate;
    private String assignTime;
    private String venue;
    private String reply;



}
