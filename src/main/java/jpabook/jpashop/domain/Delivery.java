package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)    //EnumType.ORDINAL 사용시 1,2로 구분들어가는데 상태 추가 시 꼬일 수 있어 STRING 사용!
    private DeliveryStatus status; //배송상태 [READY, COMP]

}
