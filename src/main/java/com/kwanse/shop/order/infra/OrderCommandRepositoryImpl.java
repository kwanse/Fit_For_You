package com.kwanse.shop.order.infra;

import com.kwanse.shop.order.command.domain.Order;
import com.kwanse.shop.order.command.domain.OrderCommandRepository;
import com.kwanse.shop.order.query.OrderDetailDao;
import com.kwanse.shop.order.query.OrderSummaryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderCommandRepositoryImpl implements OrderCommandRepository {

    private final OrderJpaRepository orderJpaRepository;

    private final OrderDetailDao orderDetailDao;
    private final OrderSummaryDao orderSummaryDao;

    @Override
    public Order save(Order order) {
        orderJpaRepository.save(order);

//        OrderDetail orderDetail = OrderDetail.of(order);
//        orderDetailDao.save(orderDetail);
        return order;
    }
}
