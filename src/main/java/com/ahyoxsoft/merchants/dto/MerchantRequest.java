package com.ahyoxsoft.merchants.dto;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantRequest {
    private String id;
    private String name;
    private String email;
    private String address;

    @CreatedDate
    private String created;
}
