package com.sagroup.rewardservice.commands.aggregates;

import com.sagroup.rewardservice.commonapi.commands.CreateRewardCommand;
import com.sagroup.rewardservice.commonapi.enums.RewardType;
import com.sagroup.rewardservice.commonapi.events.RewardCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RewardAggregate {

    @AggregateIdentifier
    private String rewardId;

    private String name;
    private int quantity;

    private RewardType rewardType;
    private int price;

    public RewardAggregate () {
        // Default Constructor required by AXON
    }

    @CommandHandler
    public RewardAggregate (CreateRewardCommand createRewardCommand) {
        AggregateLifecycle.apply(
                new RewardCreatedEvent(
                        createRewardCommand.getId(),
                        createRewardCommand.getName(),
                        createRewardCommand.getQuantity(),
                        createRewardCommand.getRewardType(),
                        createRewardCommand.getPrice())
        );
    }

    @EventSourcingHandler
    public void on(RewardCreatedEvent event) {
        this.rewardId = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
    }

}
