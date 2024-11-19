package com.kwanse.shop.clothes.command.application;

import com.kwanse.shop.clothes.command.domain.Clothes;
import com.kwanse.shop.clothes.command.application.dto.AddClothesRequest;
import com.kwanse.shop.clothes.command.domain.ClothesCommandRepository;
import com.kwanse.shop.common.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ClothesCommandService {

    private final ClothesCommandRepository clothesCommandRepository;

    private final ImageService imageService;
    private final ClothesSender clothesSender;

    public Long add(AddClothesRequest request, List<MultipartFile> images) {
        List<Image> uploadedImages = imageService.upload(images);
        Clothes clothes = request.to();
        clothes.addImages(uploadedImages);

        Clothes savedClothes = clothesCommandRepository.save(clothes);
        clothesSender.send(savedClothes);
        return savedClothes.getId();
    }
}
