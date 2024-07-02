package com.example.petshopmobileapp.models;

import java.math.BigDecimal;
public class Animals {
    private int id;
    private int petTypeId;
    private String breed;
    private String name;
    private int age;
    private String gender;
    private String color;
    private BigDecimal price;
    private boolean isAvailable;

    public Animals() {
        this.id = id;
        this.petTypeId = petTypeId;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.price = price;
        this.isAvailable = isAvailable;
    }
// Getters và Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
