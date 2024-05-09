package com.spring.service.walletservice.model;

import com.spring.service.walletservice.enums.Currency;

public class WalletRequestDto {

    private int userId;

    private long amount;

    public WalletRequestDto() {
    }

    public WalletRequestDto(int userId, long amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
