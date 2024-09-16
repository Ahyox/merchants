package com.ahyoxsoft.merchants.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantResponse {
    private String id;
    private String name;
    private String email;
    private String address;
    private String created;
}
