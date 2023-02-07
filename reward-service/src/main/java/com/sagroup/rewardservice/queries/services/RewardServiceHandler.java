package com.sagroup.rewardservice.queries.services;

import com.sagroup.rewardservice.commonapi.events.RewardCreatedEvent;
import com.sagroup.rewardservice.queries.entities.Reward;
import com.sagroup.rewardservice.queries.repositories.RewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class RewardServiceHandler {
    public RewardRepository rewardRepository;

    @EventHandler
    public void on(RewardCreatedEvent event) {
        log.info("*************************************");
        log.info("RewardCreatedEvent received in RewardServiceHandler");
        Reward reward = new Reward();
        reward.setRewardId(event.getId());
        reward.setName(event.getName());
        reward.setQuantity(event.getQuantity());
        reward.setRewardType(event.getRewardType());
        reward.setPrice(event.getPrice());
        rewardRepository.save(reward);
    }

    @Autowired
    public void setRewardRepository(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }
}
