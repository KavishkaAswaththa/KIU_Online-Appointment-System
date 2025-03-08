package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class LecDTO {
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



    public String getSubject() {
        return "KIU APPOINTMENT";
    }

    // Setter
    public void setSubject(String newSubject) {
        this.faculty = newSubject;
    }

    // Getters and setters

    public String getBody() {
        return "Email: "+email+"                                                                     Message: "+message +"                                                     Faculty:     "+faculty + "                                                   Student Count:    "+count+"                      PLEASE KINDLY ACCEPT THIS APPOINTMENT THROUGH THE YOUR PORTAL : ";
    }

    // Setter
    public void setBody(String newBody) {
        this.message = newBody;
    }

    // Getters and setters


    public String getTo() {
        return lecturer;
    }

    // Setter
    public void setTo(String newTo) {
        this.lecturer = newTo;
    }

    // Getters and setters



}


