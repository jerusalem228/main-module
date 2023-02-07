package com.sagroup.rewardservice.queries.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reward {

    @Id
    private String rewardId;

    private String name;

    private Integer quantity;

    private String rewardType;

    private Integer price;

}
