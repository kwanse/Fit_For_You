package com.kwanse.shop.clothes.command.application;

import com.kwanse.shop.common.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<Image> upload(List<MultipartFile> images);
}
