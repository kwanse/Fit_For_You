package com.kwanse.shop.like;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collation = "likes")
public class Like {

    @Id
    private Long clothesId;

    private List<Long> memberId;

    private Long count;

}
