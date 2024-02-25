package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CouponEntity {

    @Id
    private Long id;

    private Long membershipPlanId;
    private Long publisherUserId;
    private Long userId;
    private String status;

}
