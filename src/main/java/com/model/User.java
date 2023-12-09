package com.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 21)
    private String name;

    @Column(name = "cell")
    private String cell;

    @Column(name = "country")
    private String country;

    @Column(name = "salary")
    private int salary;

    @Column(name = "dl")
    private String dl;

    public User() {
    }

    public User(int id, String name, String cell, String country, int salary, String dl) {
        this.id = id;
        this.name = name;
        this.cell = cell;
        this.country = country;
        this.salary = salary;
        this.dl = dl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    @Override
    public String toString() {
        return "id " + id + " | " +
                "name - " + name + " | " +
                "cell: " + cell + " | " +
                "country of residence - " + country + " | " +
                "salary - " + salary + " | " +
                "driver's licence number is " + dl;
    }


}
