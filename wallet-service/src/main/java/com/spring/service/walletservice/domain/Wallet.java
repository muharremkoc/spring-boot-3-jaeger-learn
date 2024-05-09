package com.spring.service.walletservice.domain;


import com.spring.service.walletservice.enums.Currency;
import jakarta.persistence.*;


@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int walletId;

    private int userId;

    private Currency currency;

    private long amount;

    public Wallet() {
    }

    public Wallet(int walletId, int userId, Currency currency, long amount) {
        this.walletId = walletId;
        this.userId = userId;
        this.currency = currency;
        this.amount = amount;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
