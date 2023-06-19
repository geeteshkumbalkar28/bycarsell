package com.SellBuyCar.controller;

import com.SellBuyCar.Interface.IDealer;
import com.SellBuyCar.dto.DealerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dealer")
public class Dealer {
    @Autowired
    private IDealer iDealer;
    @PostMapping("/add")
    public ResponseEntity<?> addDealer(@RequestBody DealerDto dealerDto){
        iDealer.adDealer(dealerDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dealer has been Added");

    }
    @get
}
