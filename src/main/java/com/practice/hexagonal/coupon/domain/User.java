package com.practice.hexagonal.coupon.domain;

import lombok.Value;

@Value
public class User {

    private final UserId userId;

    @Value
    public static class UserId{
        private final Long id;
    }
}
