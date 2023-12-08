package com.web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name should be visible")
    @Size(min = 2, max = 21, message = "name should be real")
    @Column(name = "name", nullable = false, length = 21)
    private String name;

    @Size(min = 5, message = "cell# should be real")
    @NotEmpty(message = "name should be visible")
    @Column(name = "cell")
    private String cell;

    @NotEmpty(message = "Country should be visible")
    @Column(name = "country")
    private String country;

    @Min(value = 1, message = "no volunteers allowed here")
    @Column(name = "salary")
    private int salary;

    @NotEmpty(message = "Driver Licence should be visible")
    @Column(name = "dl")
    private String dl;

    public User() {
    }

    public User(Long id, String name, String cell, String country, int salary, String dl) {
        this.id = id;
        this.name = name;
        this.cell = cell;
        this.country = country;
        this.salary = salary;
        this.dl = dl;
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
