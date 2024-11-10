package com.kwanse.ably.clothes.ui;

import com.kwanse.ably.common.Response;
import com.kwanse.ably.clothes.command.application.ClothesCommandService;
import com.kwanse.ably.clothes.command.domain.ClothesId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ClothesController {

    private final ClothesCommandService clothesCommandService;


    @PostMapping
    public Response<ClothesId> addClothes(@RequestBody AddClothesRequest request) {
        ClothesId id = clothesCommandService.add(request);
        return Response.ok(id);
    }
}
