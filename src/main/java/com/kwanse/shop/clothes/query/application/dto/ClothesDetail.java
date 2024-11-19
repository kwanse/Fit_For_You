package com.kwanse.shop.clothes.query.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.kwanse.shop.clothes.command.domain.value.*;
import com.kwanse.shop.common.model.Image;
import com.kwanse.shop.common.model.Money;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public final class ClothesDetail {

    public static final ClothesDetail EMPTY = new ClothesDetail(-1L);

    private Long id;

    private ClothesInfo clothesInfo;
    private Seller seller;

    private List<Image> images;
    private List<ClothesSize> sizes;
    private List<Color> colors;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;


    private ClothesDetail(Long id) {
        this.id = id;
    }
}
