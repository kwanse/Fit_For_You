package com.kwanse.shop.clothes.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesCommandRepository extends JpaRepository<Clothes, Long> {
}
