package com.ahyoxsoft.merchants.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahyoxsoft.merchants.dto.MerchantProduct;
import com.ahyoxsoft.merchants.dto.MerchantRequest;
import com.ahyoxsoft.merchants.dto.MerchantResponse;
import com.ahyoxsoft.merchants.service.MerchantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;


    @PostMapping(path = "/merchant")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMerchant(@RequestBody MerchantRequest merchant) {
        merchantService.createMerchant(merchant);
    }

    @GetMapping(path = "/merchant/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MerchantResponse getMerchant(@PathVariable String id) throws Exception {
        return merchantService.getMerchant(id);
    }

    @GetMapping(path = "/merchant/product/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<MerchantProduct > getMerchantProduct(@PathVariable String id) throws Exception {
        return merchantService.getMerchantProduct(id);
    }
}
