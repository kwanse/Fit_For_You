package com.kwanse.shop.clothes.ui;

import com.kwanse.shop.clothes.command.application.dto.AddClothesRequest;
import com.kwanse.shop.clothes.query.application.ClothesQueryService;
import com.kwanse.shop.clothes.query.application.dto.ClothesDetail;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;
import com.kwanse.shop.common.Response;
import com.kwanse.shop.clothes.command.application.ClothesCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ClothesController {

    private final ClothesCommandService clothesCommandService;
    private final ClothesQueryService clothesQueryService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public Response<Long> addClothes(
            @RequestPart(value = "request") AddClothesRequest request,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) {
        Long id = clothesCommandService.add(request, images);
        return Response.ok(id);
    }

    @GetMapping("/{clothesId}")
    public Response<ClothesDetail> readClothesDetail(
            @PathVariable("clothesId") Long clothesId
    ) {
        ClothesDetail detail = clothesQueryService.getClothesDetail(clothesId);
        return Response.ok(detail);
    }

    @GetMapping("/list")
    public Response<List<ClothesSummary>> findAll(
            @RequestParam(required = false, name = "lastId") Long lastId
    ) {
        List<ClothesSummary> summaries = clothesQueryService.getClothesSummary(lastId);
        return Response.ok(summaries);
    }

    @GetMapping("/ranking")
    public Response<List<ClothesSummary>> findAllRanking() {
        List<ClothesSummary> responses = clothesQueryService.getRankedClothesSummary();
        return Response.ok(responses);
    }
}
