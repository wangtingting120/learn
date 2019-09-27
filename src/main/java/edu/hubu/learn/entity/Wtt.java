package edu.hubu.learn.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wtt")
@Data
public class Wtt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;
    private int age;
    private String city;
}