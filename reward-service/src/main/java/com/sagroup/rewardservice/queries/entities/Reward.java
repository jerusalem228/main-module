package com.sagroup.rewardservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Reward {
    @Id
    private String rewardId;

    private String name;

    private int quantity;

    private int price;
}
