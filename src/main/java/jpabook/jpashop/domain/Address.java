package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter //@setter 제거, 생성자에서 값 타입은 변경 불가능한 클래스로 만듬
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {   // public보다 protected가 더 안전함.
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
