package com.practice.hexagonal.coupon.domain;

import lombok.Value;

@Value
public class User {

    private final UserId userId;

    private final IssuerUserId issuerUserId;

    @Value
    public static class UserId{
        private final Long id;
    }

    @Value
    public static class IssuerUserId{
        private final Long id;
    }
}
