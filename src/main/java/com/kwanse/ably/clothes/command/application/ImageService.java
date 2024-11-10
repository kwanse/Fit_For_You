package com.kwanse.ably.clothes.command.application;

import com.kwanse.ably.common.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<Image> upload(List<MultipartFile> images);
}
