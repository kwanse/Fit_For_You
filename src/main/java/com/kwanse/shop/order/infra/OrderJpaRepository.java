package com.kwanse.shop.order.infra;

import com.kwanse.shop.order.command.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
