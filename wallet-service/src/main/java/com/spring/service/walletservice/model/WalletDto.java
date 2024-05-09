package com.spring.service.walletservice.model;

import com.spring.service.walletservice.domain.Wallet;
import com.spring.service.walletservice.feign.model.User;

import java.util.List;

public class WalletDto {

    private int walletId;

    private User user;

    private List<Wallet> wallets;

    public WalletDto() {
    }

    public WalletDto(int walletId, User user, List<Wallet> wallets) {
        this.walletId = walletId;
        this.user = user;
        this.wallets = wallets;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }
}
