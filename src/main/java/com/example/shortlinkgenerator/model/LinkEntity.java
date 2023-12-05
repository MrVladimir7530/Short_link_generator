package com.example.shortlinkgenerator.model;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity(name = "links")
public class LinkEntity {
    @Column(name = "link_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "long_link")
    private String longLink;
    @Column(name = "short_link")
    private String shortLink;
    @Column(name = "registered_at")
    private LocalDateTime registeredAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
