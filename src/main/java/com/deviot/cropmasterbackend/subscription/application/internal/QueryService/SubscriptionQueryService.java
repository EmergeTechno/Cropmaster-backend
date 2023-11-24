package com.deviot.cropmasterbackend.subscription.application.internal.QueryService;

import com.deviot.cropmasterbackend.subscription.domain.model.aggregates.Subscription;
import com.deviot.cropmasterbackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;
import com.deviot.cropmasterbackend.subscription.domain.services.queryService.ISubscriptionQueryService;
import com.deviot.cropmasterbackend.subscription.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionQueryService implements ISubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery) {
        Optional<Subscription> subscription=Optional.ofNullable(subscriptionRepository.findSubscriptionByAccountId(getSubscriptionByAccountIdQuery.accountId()));
        if(subscription.isPresent()){
            return subscription.get();
        }else {
            return null;
        }
    }
}
