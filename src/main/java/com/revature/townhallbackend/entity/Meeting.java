package com.revature.townhallbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meeting_id;
    private String title;
    private String address;
    private Long time;
    private String summary;


    public Meeting(String title, String address, Long time, String summary) {
        this.title = title;
        this.address = address;
        this.time = time;
        this.summary = summary;
    }
}
