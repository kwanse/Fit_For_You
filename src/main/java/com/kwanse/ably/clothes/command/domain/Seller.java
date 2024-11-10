package com.kwanse.ably.clothes.command.domain;

import com.kwanse.ably.member.MemberId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    @AttributeOverride(name = "id", column = @Column(name = "seller_id"))
    private MemberId memberId;
    private String name;

    public Seller(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
