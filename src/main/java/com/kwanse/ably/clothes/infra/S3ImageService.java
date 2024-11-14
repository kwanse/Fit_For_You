package com.kwanse.ably.clothes.infra;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.kwanse.ably.clothes.command.application.ImageService;
import com.kwanse.ably.common.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ImageService implements ImageService {

    private final AmazonS3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public List<Image> upload(List<MultipartFile> images) {
        List<Image> imageList = new ArrayList<>();
        if (images == null || images.isEmpty()) {
            return new ArrayList<>();
        }

        for (MultipartFile image : images) {
            Image storedImage = upload(image);
            imageList.add(storedImage);
        }
        return imageList;
    }

    private Image upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String storeName = UUID.randomUUID() + originalFilename;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        return uploadOnS3(file, storeName, metadata, originalFilename);
    }

    private Image uploadOnS3(
            MultipartFile file,
            String storeName,
            ObjectMetadata metadata,
            String originalFilename
    ) {
        try {
            s3Client.putObject(bucket, storeName, file.getInputStream(), metadata);
            URL url = s3Client.getUrl(bucket, storeName);
            return new Image(originalFilename, storeName, url.toString());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
