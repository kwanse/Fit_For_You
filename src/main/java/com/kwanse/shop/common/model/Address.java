package com.kwanse.shop.common.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Address {

    private Integer postCode;
    private String detail;

    public Address(Integer postCode, String detail) {
        this.postCode = postCode;
        this.detail = detail;
    }
}
