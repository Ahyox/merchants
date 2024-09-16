package com.ahyoxsoft.merchants.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "merchants")
public class Merchant {
    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private String created;
}
