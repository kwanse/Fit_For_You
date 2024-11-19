package com.kwanse.shop.clothes.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesItemCommandRepository extends JpaRepository<ClothesItem, Long> {
}
