package com.kwanse.ably.like;

import com.kwanse.ably.member.MemberId;
import com.kwanse.ably.clothes.command.domain.ClothesId;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collation = "likes")
public class Like {

    @Id
    private ClothesId clothesId;

    private List<MemberId> memberId;

    private Long count;

}
