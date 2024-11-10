package com.kwanse.ably.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Password {

    @Column(name = "password")
    private String value;

    public Password(String value) {
        this.value = value;
    }

    public boolean match(final String password) {
        return this.value.equals(password);
    }
}
