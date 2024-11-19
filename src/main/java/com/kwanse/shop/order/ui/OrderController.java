package com.kwanse.shop.order.ui;

import com.kwanse.shop.common.Response;
import com.kwanse.shop.order.command.application.OrderCommandService;
import com.kwanse.shop.order.command.application.dto.PlaceOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderCommandService orderCommandService;

    @PostMapping
    public Response<Long> placeOrder(PlaceOrderRequest request) {
//        orderCommandService.placeOrder(request);
        return Response.ok(-1L);
    }
}
