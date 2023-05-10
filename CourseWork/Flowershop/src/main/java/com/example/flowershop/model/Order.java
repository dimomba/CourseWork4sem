package com.example.flowershop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flower;
    private int count;
    private int priceforone;
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public Order(String flower, int count, int priceforone, int cost, User user) {
        this.flower = flower;
        this.count = count;
        this.priceforone = priceforone;
        this.cost = cost;
        this.user = user;
    }
}
