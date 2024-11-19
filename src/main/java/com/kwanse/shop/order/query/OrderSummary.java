package com.kwanse.shop.order.query;

import com.kwanse.shop.common.model.Address;
import com.kwanse.shop.common.model.DiscountRate;
import com.kwanse.shop.common.model.Money;
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
public class OrderSummary {

    @Id
    private Long id;

    @Embedded
    private Address shippingAddress;

    @ElementCollection
    @CollectionTable(
            name = "order_line",
            joinColumns = @JoinColumn(name = "order_id")
    )
    private List<String> orderTitle = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DiscountRate discountRate;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_amount"))
    private Money totalAmount;

    private OrderSummary(
            Long id,
            Address shippingAddress,
            List<String> orderTitle,
            DiscountRate discountRate,
            Money totalAmount
    ) {
        this.id = id;
        this.shippingAddress = shippingAddress;
        this.orderTitle = orderTitle;
        this.discountRate = discountRate;
        this.totalAmount = totalAmount;
    }

    /*public static OrderSummary of(Order order) {
        return new OrderSummary(
                order.getId(),
                order.getShippingAddress(),
                order.getOrderLines(),
                order.getAppliedCoupon().getDiscountRate(),
        )
    }*/
}
