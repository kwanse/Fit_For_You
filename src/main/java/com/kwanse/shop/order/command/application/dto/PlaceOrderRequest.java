package com.kwanse.shop.order.command.application.dto;

import com.kwanse.shop.common.model.Address;
import com.kwanse.shop.order.command.domain.AppliedCoupon;
import com.kwanse.shop.order.command.domain.OrderLine;
import com.kwanse.shop.order.command.domain.Orderer;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderRequest {

    private Orderer orderer;

    @Embedded
    private Address shippingAddress;

    @ElementCollection
    @CollectionTable(
            name = "order_line",
            joinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderLine> orderLines = new ArrayList<>();

    @Embedded
    private AppliedCoupon appliedCoupon;
}
