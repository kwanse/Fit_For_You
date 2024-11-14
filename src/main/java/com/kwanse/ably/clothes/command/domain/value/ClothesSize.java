package com.kwanse.ably.clothes.command.domain.value;

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
public class ClothesSize {

    @Column(name = "clothes_size")
    private String value;

    public ClothesSize(String value) {
        this.value = value;
    }

}
