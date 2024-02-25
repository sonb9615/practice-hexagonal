# 멤버십 쿠폰 구독

## 쿠폰 생성 / 조회
    - POST /api/vi/coupon
    - GET /api/vi/coupon
    - 작가 사이드에서 쿠폰 생성 가능

## 쿠폰 랜덤 선물
    - 이미 멤버십 플랜 구독중인 사람
    - 구독은 하였으나 멤버십 플랜에 구독은 해본 적 없는 사람

## 쿠폰 사용
    - 멤버십 처음 등록한 사람
        - 이건 자동 진행이 안됨 -> 해당 건은 자동결제 등록을 해야하기 때문에..
        - 쿠폰 status : activate 
    - 멤버십 이미 등록한 사람
        - 이미 자동 결제를 지정 해놓음
        - 시기를 정할 수 없음
        - 다음 달 결제가 0으로 진행
        - 쿠폰 status : reserved
    - 쿠폰을 사용하고서는 취소 되지 않음 -> 미뤄지지 않음

## 테이블
    - Coupon -> membershipPlanCoupon
        - id
        - membership_plan_id
        - started_at
        - expired_at
        - user_id
        - issuer_id
        - status
    - User
        - id
    - MembershipPlan
        - id
        - title
        - started_at
        - ended_at
        - created_at
    - Membership
        - user_id
        - started_at
        - ended_at
    - TransactionMembership
        - 
    