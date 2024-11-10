package com.kwanse.ably.member;

import com.kwanse.ably.common.model.Address;
import com.kwanse.ably.common.model.Email;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @EmbeddedId
    private MemberId id;

    private String name;

    private String nickname;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    private String loginId;
}
