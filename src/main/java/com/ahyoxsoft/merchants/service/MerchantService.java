package com.ahyoxsoft.merchants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.ahyoxsoft.merchants.dto.MerchantProduct;
import com.ahyoxsoft.merchants.dto.MerchantRequest;
import com.ahyoxsoft.merchants.dto.MerchantResponse;
import com.ahyoxsoft.merchants.model.Merchant;
import com.ahyoxsoft.merchants.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final WebClient webClient;

    public void createMerchant(MerchantRequest merchantRequest) {
        Merchant merchant = Merchant.builder()
        .address(merchantRequest.getAddress())
        .email(merchantRequest.getEmail())
        .name(merchantRequest.getName()).build();

        merchantRepository.save(merchant);
        log.info("Merchant with id: {} existed", merchant.getId());
    }

    public MerchantResponse getMerchant(String id) throws Exception {
        //merchantRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        Optional<Merchant> merchantOptional = merchantRepository.findById(id);
        if (merchantOptional.isPresent()) {
            Merchant merchant = merchantOptional.get();

            return MerchantResponse.builder()
            .address(merchant.getAddress())
            .created(merchant.getCreated())
            .email(merchant.getEmail())
            .id(merchant.getId())
            .name(merchant.getName()).build();
        } else {
            throw new Exception("No merchant found!");
        }
    }

    public List<MerchantProduct> getMerchantProduct(String id) {
        return webClient.get()
        .uri(String.format("http://localhost:8080/api/product/merchant/%s", id))
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<MerchantProduct>>() {})
        .block();
    }
}
