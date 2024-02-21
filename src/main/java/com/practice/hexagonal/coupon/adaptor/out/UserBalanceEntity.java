package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserBalanceEntity {

    @Id
    private Long id;

    private Long userId;
    private Long point;

}
