package com.kwanse.ably.clothes.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesCommandRepository extends JpaRepository<Clothes, ClothesId> {
}
