package com.kwanse.shop.order.command.application;

import com.kwanse.shop.order.command.domain.OrderCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandService {

    private final OrderCommandRepository orderCommandRepository;

    /*public Long placeOrder(PlaceOrderRequest request) {


    }*/
}
