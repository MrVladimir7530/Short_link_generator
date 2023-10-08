package com.example.shortlinkgenerator.model;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
public class LinkEntity {
    @Id
    private Long Id;
    private String longLink;
    private String shortLink;
    private LocalDateTime registeredAt;
}
