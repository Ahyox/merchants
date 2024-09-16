package com.ahyoxsoft.merchants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahyoxsoft.merchants.model.Merchant;

public interface MerchantRepository extends MongoRepository<Merchant, String> {

}
