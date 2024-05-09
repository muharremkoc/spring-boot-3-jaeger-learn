package com.spring.service.walletservice.service;

import com.spring.service.walletservice.domain.Wallet;
import com.spring.service.walletservice.enums.Currency;
import com.spring.service.walletservice.exceptions.UserNotFoundException;
import com.spring.service.walletservice.feign.client.ApiFeignClient;
import com.spring.service.walletservice.feign.model.User;
import com.spring.service.walletservice.model.WalletDto;
import com.spring.service.walletservice.model.WalletRequestDto;
import com.spring.service.walletservice.repository.WalletRepository;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.NewSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{

    Logger log= LoggerFactory.getLogger(WalletServiceImpl.class);

    private final WalletRepository walletRepository;

     final ApiFeignClient apiFeignClient;

  public WalletServiceImpl(WalletRepository walletRepository, @Qualifier("apiFeignFactory") ApiFeignClient apiFeignClient) {
        this.walletRepository = walletRepository;
        this.apiFeignClient = apiFeignClient;
    }

    @Override
    @NewSpan(value = "wallet-service-create-wallet-span")
    public Wallet createWallet(WalletRequestDto walletRequestDto, Currency currency) throws UserNotFoundException {
        WalletDto walletDto = new WalletDto();
        Wallet wallet=walletRepository.findByUserIdAndCurrency(walletRequestDto.getUserId(),currency);
        User user=apiFeignClient.getUser(walletRequestDto.getUserId());
        if (user==null){
            log.info("User Not Found with ID:{}", walletRequestDto.getUserId());
            throw new UserNotFoundException("Wallet Not Found with ID:"+walletRequestDto.getUserId());

        }
        else {
            if(wallet==null){

                wallet=new Wallet();
                wallet.setUserId(user.getId());
                wallet.setCurrency(currency);
                wallet.setAmount(walletRequestDto.getAmount());
                walletRepository.save(wallet);

            }else {
                wallet.setAmount(wallet.getAmount()+walletRequestDto.getAmount());
                wallet.setCurrency(wallet.getCurrency());
                walletRepository.save(wallet);
            }
        }
        return wallet;
    }

    @Override
    public List<WalletDto> getWallets() {
        List<Wallet> wallets=walletRepository.findAll();
        List<WalletDto> walletDtos=new ArrayList<>();

        wallets.forEach(wallet -> {
            User user=apiFeignClient.getUser(wallet.getUserId());
            if (user==null){
                log.info("User Not Found with ID:{}", user.getId());
                throw new RuntimeException("User Not Found with ID:"+user.getId());
            }
            WalletDto walletDto=new WalletDto();
            walletDto.setUser(user);
            walletDto.setWallets(walletRepository.findAllByUserId(user.getId()));
            walletDtos.add(walletDto);
        });
        log.info("Get Wallets Successfully");

        return walletDtos;
    }

    @Override
    public Wallet getWalletById(int id) {
        Wallet wallet=walletRepository.findByWalletId(id);
        if (wallet==null){
            log.info("Wallet Not Found with ID:{}", id);
            throw new RuntimeException("Wallet Not Found with ID:"+id);
        }
        return wallet;
    }
}
