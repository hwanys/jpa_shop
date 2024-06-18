package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id") //Member와 관계 설정 .. 여기가 주인이 됨.
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "delivery_id")   //OneToOne 일때 어디든 상관 없지만! 많이 쓰일 것 같은 곳에 JoinColumn 두는 걸 추천!
    private Delivery delivery;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;    //주문상태 [ORDER, CANCEL]

}
