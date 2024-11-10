package com.kwanse.ably.common.model;

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
public class Email {

    private static final String EMAIL_FORMAT = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    @Column(name = "email")
    private String value;

    public Email(String value) {
        this.value = setValue(value);
    }

    private String setValue(final String value) {
        if (value.matches(EMAIL_FORMAT)) {
            throw new EmailFormatException();
        }
        return value;
    }
}
