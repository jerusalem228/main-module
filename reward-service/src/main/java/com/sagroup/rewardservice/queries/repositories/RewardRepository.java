package com.sagroup.rewardservice.queries.repositories;

import com.sagroup.rewardservice.queries.entities.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardRepository extends MongoRepository<Reward, String> {
}
