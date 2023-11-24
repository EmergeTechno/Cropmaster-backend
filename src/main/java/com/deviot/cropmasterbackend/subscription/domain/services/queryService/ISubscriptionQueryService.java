package com.deviot.cropmasterbackend.subscription.domain.services.queryService;

import com.deviot.cropmasterbackend.subscription.domain.model.aggregates.Subscription;
import com.deviot.cropmasterbackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;

public interface ISubscriptionQueryService {
    Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery);
}
