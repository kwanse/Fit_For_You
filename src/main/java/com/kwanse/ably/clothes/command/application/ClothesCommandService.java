package com.kwanse.ably.clothes.command.application;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.ClothesCommandRepository;
import com.kwanse.ably.clothes.command.domain.ClothesId;
import com.kwanse.ably.clothes.ui.AddClothesRequest;
import com.kwanse.ably.common.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesCommandService {

    private final ClothesCommandRepository clothesCommandRepository;
    private final ImageService imageService;

    public ClothesId add(AddClothesRequest request) {
        List<Image> uploadedImages = imageService.upload(request.images());

        Clothes clothes = request.to();
        clothes.addImages(uploadedImages);
        return clothesCommandRepository.save(clothes).getId();
    }

}
