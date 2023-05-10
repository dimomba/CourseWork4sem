package com.example.flowershop.web.dto;

import lombok.Data;

@Data
public class OrderDto {

    private String flower;
    private int count;
    private int priceforone;
    private int cost;
    public OrderDto() {
    }

    public OrderDto(String flower, int count, int priceforone, int cost) {
        super();
        this.flower = flower;
        this.count = count;
        this.priceforone = priceforone;
        this.cost = cost;
    }
}
