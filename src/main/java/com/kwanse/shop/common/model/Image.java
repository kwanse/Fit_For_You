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
public class Image {

    private String originalName;
    private String storeName;
    private String imageUrl;

    public Image(String originalName, String storeName, String imageUrl) {
        this.originalName = originalName;
        this.storeName = storeName;
        this.imageUrl = imageUrl;
    }
}
