package com.example.shortlinkgenerator.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class UserEntity {
    @Id
    private Long Id;

}
