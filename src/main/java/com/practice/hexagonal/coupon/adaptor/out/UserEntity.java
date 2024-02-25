package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {

    @Id
    private Long id;

}
