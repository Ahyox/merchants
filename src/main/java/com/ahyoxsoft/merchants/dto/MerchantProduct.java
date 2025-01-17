package com.ahyoxsoft.merchants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantProduct {
    private Long id;
    private String merchantId;
    private String name;
    private Double price;
    private String type;
    private String createdAt;
}
