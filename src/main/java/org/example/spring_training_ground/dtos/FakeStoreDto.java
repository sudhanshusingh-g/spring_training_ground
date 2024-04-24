package org.example.spring_training_ground.dtos;

import lombok.Data;

@Data
public class FakeStoreDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
