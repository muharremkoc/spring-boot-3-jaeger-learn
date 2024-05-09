package com.spring.service.walletservice.feign.client;

import com.spring.service.walletservice.feign.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", url = "http://localhost:2329/user")
public interface ApiFeignClient {


    @GetMapping("/{id}")
    User getUser (@PathVariable("id") Integer userId);

}