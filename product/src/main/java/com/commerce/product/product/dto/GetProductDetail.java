package com.commerce.product.product.dto;


import com.commerce.product.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GetProductDetail {

    @Getter
    public static class Request {

    }



    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {
        private ProductDetailDto productDetailDto;

        public static Response from(ProductDetailDto productDetailDto) {
            return Response.builder()
                    .build();
        }
    }
}
