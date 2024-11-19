package com.kwanse.shop.order.query;

import com.kwanse.shop.common.model.Address;
import com.kwanse.shop.common.model.Money;
import com.kwanse.shop.order.command.domain.AppliedCoupon;
import com.kwanse.shop.order.command.domain.OrderLine;
import com.kwanse.shop.order.command.domain.Orderer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {

    @Id
    private Long id;

    @Embedded
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

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_amount"))
    private Money totalAmount;

    private OrderDetail(
            Long id,
            Orderer orderer,
            Address shippingAddress,
            List<OrderLine> orderLines,
            AppliedCoupon appliedCoupon,
            Money totalAmount
    ) {
        this.id = id;
        this.orderer = orderer;
        this.shippingAddress = shippingAddress;
        this.orderLines = orderLines;
        this.appliedCoupon = appliedCoupon;
        this.totalAmount = totalAmount;
    }

    /*public static OrderDetail of(Order order) {
        return new OrderDetail(
                order.getId(),
                order.getOrderer(),
                order.getShippingAddress(),
                order.getOrderLines(),
                order.getAppliedCoupon(),
                order.getTotalAmount()
        );
    }*/
}
