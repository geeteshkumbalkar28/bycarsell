package com.SellBuyCar.controller;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarRegister iCarRegister;
    @PostMapping(value = "/carregister")
    public String carRegisteration(@RequestBody CarDto carDto){

        return iCarRegister.AddCarDetails(carDto);
    }

}
