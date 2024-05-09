package com.spring.service.walletservice.controller;

import com.spring.service.walletservice.domain.Wallet;
import com.spring.service.walletservice.enums.Currency;
import com.spring.service.walletservice.exceptions.UserNotFoundException;
import com.spring.service.walletservice.model.WalletDto;
import com.spring.service.walletservice.model.WalletRequestDto;
import com.spring.service.walletservice.service.WalletService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet create(@RequestBody WalletRequestDto walletRequestDto, @RequestParam Currency currency) throws UserNotFoundException {
        return walletService.createWallet(walletRequestDto, currency);
    }

    @GetMapping
    public List<WalletDto> getWallets() throws UserNotFoundException {
        return walletService.getWallets();
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable int id){
        return walletService.getWalletById(id);
    }


}
