package com.example.demo1.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="artists")
public class Player {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="id")
    private  Integer id;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;

    public Player() {

    }

    public Player(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
