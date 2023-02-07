package com.sagroup.rewardservice.commands.controllers;

import com.sagroup.rewardservice.commonapi.commands.CreateRewardCommand;
import com.sagroup.rewardservice.commonapi.dtos.RewardDto;
import com.sagroup.rewardservice.queries.entities.Reward;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/reward")
public class RewardCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createReward(@RequestBody RewardDto rewardDto) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRewardCommand(
                UUID.randomUUID().toString(),
                rewardDto.getName(),
                rewardDto.getQuantity(),
                rewardDto.getRewardType().toString(),
                rewardDto.getPrice()
                )
        );
        return commandResponse;
    }

    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    public void setEventStore(EventStore eventStore) {
        this.eventStore = eventStore;
    }
}
