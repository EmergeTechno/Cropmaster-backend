package com.deviot.cropmasterbackend.subscription.infrastructure;

import com.deviot.cropmasterbackend.subscription.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Subscription findSubscriptionByAccountId(Long accountId);
}
