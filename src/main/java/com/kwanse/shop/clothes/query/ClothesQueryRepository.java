package com.kwanse.shop.clothes.query;

import com.kwanse.shop.clothes.query.application.dto.ClothesDetail;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ClothesQueryRepository extends MongoRepository<ClothesView, Long>, ClothesQueryRepositoryCustom {

    Optional<ClothesDetail> findDetailById(Long id);
}
