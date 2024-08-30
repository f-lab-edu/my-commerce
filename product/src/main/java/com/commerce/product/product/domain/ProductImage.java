package com.commerce.product.product.domain;

import com.commerce.product.image.ImageDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImageId;

    private String imageFileName;
    private String imageFileOriName;
    private String imageFileUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public static ProductImage of(ImageDto imageDto) {
        return ProductImage.builder()
                .imageFileName(imageDto.getImageFileName())
                .imageFileOriName(imageDto.getImageFileOriName())
                .imageFileUrl(imageDto.getImageFileUrl())
                .build();
    }
}
