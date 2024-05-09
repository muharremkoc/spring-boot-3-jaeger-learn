package com.spring.service.walletservice.repository;

import com.spring.service.walletservice.domain.Wallet;
import com.spring.service.walletservice.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {

    Wallet findByUserIdAndCurrency(int userId,Currency currency);
    List<Wallet> findAllByUserId(int userId);
    Wallet findByWalletId(int walletId);

}
