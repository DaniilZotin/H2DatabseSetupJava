package com.phcodegyan.H2DatabseSetup.db;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Entity
@Table(name = "persons")
@Component
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_person")
    private String name;

    @Column(name = "birthday_person")
    private LocalDate birthday;



    // Construct
    public Person() {

    }

    public Person(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
    }



    public Person(String name, Long id){
        this.name = name;
        this.id = id;
    }

    public LocalDate getBirth() {
        return birthday;
    }

    public void setBirth(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
