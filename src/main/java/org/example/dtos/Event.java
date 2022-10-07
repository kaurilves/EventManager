package org.example.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Event implements Serializable {
    private  String name;
    private  String address;
    private  LocalDateTime eventDate;
    private  String additionalInfo;
}