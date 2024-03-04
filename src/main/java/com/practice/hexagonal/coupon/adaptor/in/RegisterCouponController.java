package com.practice.hexagonal.coupon.adaptor.in;

import com.practice.hexagonal.coupon.application.port.in.RegisterCouponUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterCouponController {

    private RegisterCouponUseCase registerCouponUseCase;

    @PostMapping("/coupon/{couponId}/register/by/userId/{userId}")
    public void register(@PathVariable Long couponId, @PathVariable Long userId){

    }


}
