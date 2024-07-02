package com.example.petshopmobileapp.models;

public class OrderAnimal {
    private int orderId;
    private int animalId;
    private int quantity;

    public OrderAnimal(int orderId, int animalId, int quantity) {
        this.orderId = orderId;
        this.animalId = animalId;
        this.quantity = quantity;
    }
    // Getters và Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
