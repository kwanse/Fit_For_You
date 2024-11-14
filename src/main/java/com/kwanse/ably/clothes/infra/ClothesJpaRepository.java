package com.kwanse.ably.clothes.infra;

import com.kwanse.ably.clothes.command.domain.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesJpaRepository extends JpaRepository<Clothes, Long> {
}
