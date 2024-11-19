package com.kwanse.shop.clothes.infra.rabbitmq;

import com.kwanse.shop.clothes.command.domain.Clothes;
import com.kwanse.shop.clothes.command.domain.ClothesSavedEvent;
import com.kwanse.shop.clothes.query.ClothesQueryRepository;
import com.kwanse.shop.clothes.query.ClothesView;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitClothesListener {

    private final ClothesQueryRepository clothesQueryRepository;

    @RabbitListener(queues = "clothes")
    public void receiveMessage(ClothesSavedEvent event) {
        Clothes clothes = event.clothes();
        clothesQueryRepository.save(new ClothesView(clothes));
    }
}
