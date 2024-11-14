package com.kwanse.ably.clothes.ui;

import com.kwanse.ably.clothes.command.application.dto.AddClothesRequest;
import com.kwanse.ably.clothes.query.ClothesDetail;
import com.kwanse.ably.clothes.query.ClothesSummary;
import com.kwanse.ably.clothes.query.application.ClothesQueryService;
import com.kwanse.ably.common.Response;
import com.kwanse.ably.clothes.command.application.ClothesCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @PathVariable("clothesId") Long clothesId) {

        ClothesDetail detail = clothesQueryService.getClothesDetail(clothesId);
        return Response.ok(detail);
    }

    @GetMapping("/list/{clothesId}")
    public Response<List<ClothesSummary>> findAll(
            @PathVariable("clothesId") Long lastId) {

        List<ClothesSummary> summaries = clothesQueryService.getClothesSummary(lastId);
        return Response.ok(summaries);
    }
}
