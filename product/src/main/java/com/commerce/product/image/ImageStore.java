package com.commerce.product.image;

import com.commerce.product.product.exception.ProductException;
import com.commerce.product.product.exception.ProductExceptionCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ImageStore {

    @Value("${image.path}")
    private String imagePath;

    public List<ImageDto> storeImage(List<MultipartFile> imageFiles) {
        return imageFiles.stream()
                .map(i -> storeImage(i))
                .collect(Collectors.toList());
    }

    public ImageDto storeImage(MultipartFile imageFile) {
        try {
            // 파일이 비었을 때 예외처리
            if (imageFile.isEmpty()) {
                throw new RuntimeException("빈 파일입니다.");
            }

            String imageOriName = imageFile.getOriginalFilename();
            String storeName = createStoreImageName(imageOriName);

            imageFile.transferTo(new File(getFullPath(storeName)));

            return new ImageDto(storeName, imageOriName, imagePath.substring(2) + storeName);
        } catch (IOException e) {
            throw new RuntimeException("잘못된 이미지");
        }
    }

    public String getFullPath(String storeName){
        return imagePath + storeName;
    }

    private String createStoreImageName(String originalImageName) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalImageName);
        return uuid + ext;
    }

    private String extractExt(String originalImageName) {
        int idx = originalImageName.lastIndexOf(".");
        return originalImageName.substring(idx);
    }



}
