package com.kwanse.ably.clothes.infra;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;
import com.kwanse.ably.clothes.command.application.ImageService;
import com.kwanse.ably.common.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ImageService implements ImageService {

    private final AmazonS3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Override
    public List<Image> upload(List<MultipartFile> images) {


        return List.of();
    }

    private Image upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String storeName = UUID.randomUUID() + originalFilename;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        s3Client.putObject(bucket, originalFilename, file.getInputStream(), metadata);
        URL url = s3Client.getUrl(bucket, originalFilename);



    }
}
