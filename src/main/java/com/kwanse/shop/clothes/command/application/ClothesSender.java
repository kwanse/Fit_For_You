package com.kwanse.shop.clothes.command.application;

import com.kwanse.shop.clothes.command.domain.Clothes;

public interface ClothesSender {

    void send(Clothes clothes);
}
