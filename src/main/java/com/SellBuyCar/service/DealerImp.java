package com.SellBuyCar.service;

import com.SellBuyCar.Interface.IDealer;
import com.SellBuyCar.dto.DealerDto;
import com.SellBuyCar.model.Dealer;
import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.DealerRepo;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class DealerImp implements IDealer {
    @Autowired
    private DealerRepo dealerRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public String adDealer(DealerDto dealerDto) {
        Dealer dealer = dealerRepo.findByEmail(dealerDto.email);

//        if(dealer!=null){
//            return "Email is all ready Exist";
//        }
        User user=new User();


        byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
        String encryptPassword=new String(encrypt);
        user.setPassword(encryptPassword);
        user.setEmail(dealerDto.email);
        user.setMobileNo(dealerDto.mobileNo);
        Dealer dealerData=new Dealer(dealerDto);
        user.setDealers(dealerData);
        userRepo.save(user);
        return "Dealer Added";
    }
}
