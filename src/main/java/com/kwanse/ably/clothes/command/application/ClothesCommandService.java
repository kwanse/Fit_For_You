package com.kwanse.ably.clothes.command.application;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.ClothesCommandRepository;
import com.kwanse.ably.clothes.command.application.dto.AddClothesRequest;
import com.kwanse.ably.common.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ClothesCommandService {

    private final ClothesCommandRepository clothesCommandRepository;
    private final ImageService imageService;

    public Long add(AddClothesRequest request, List<MultipartFile> images) {
        List<Image> uploadedImages = imageService.upload(images);

        Clothes clothes = request.to();
        clothes.addImages(uploadedImages);
        return clothesCommandRepository.save(clothes).getId();
    }

}
