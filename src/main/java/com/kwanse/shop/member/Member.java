package com.kwanse.shop.member;

import com.kwanse.shop.common.model.Address;
import com.kwanse.shop.common.model.Email;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    private String loginId;
}
