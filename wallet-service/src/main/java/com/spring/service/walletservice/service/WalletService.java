package com.spring.service.walletservice.service;

import com.spring.service.walletservice.domain.Wallet;
import com.spring.service.walletservice.enums.Currency;
import com.spring.service.walletservice.exceptions.UserNotFoundException;
import com.spring.service.walletservice.model.WalletDto;
import com.spring.service.walletservice.model.WalletRequestDto;

import java.util.List;

public interface WalletService {

    Wallet createWallet(WalletRequestDto walletRequestDto,Currency currency) throws UserNotFoundException;

    List<WalletDto> getWallets() throws UserNotFoundException;

    Wallet getWalletById(int id);

}
