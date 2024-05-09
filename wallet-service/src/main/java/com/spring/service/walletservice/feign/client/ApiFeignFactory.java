package com.spring.service.walletservice.feign.client;

import com.spring.service.walletservice.feign.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ApiFeignFactory implements ApiFeignClient {

    final ApiFeignClient apiFeignClient;

    public ApiFeignFactory(@Qualifier("com.spring.service.walletservice.feign.client.ApiFeignClient") ApiFeignClient apiFeignClient) {
        this.apiFeignClient = apiFeignClient;
    }

    @Override
    public User getUser(Integer userId) {
        return apiFeignClient.getUser(userId);
    }

}