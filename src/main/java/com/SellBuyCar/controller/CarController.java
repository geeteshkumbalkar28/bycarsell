package com.SellBuyCar.controller;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarRegister iCarRegister;
    @PostMapping(value = "/carregister")
    public String carRegisteration(@RequestBody CarDto carDto){

        return iCarRegister.AddCarDetails(carDto);
    }
    @PutMapping("/edit/{id}")
    public String CarEdit(@RequestBody CarDto carDto,@PathVariable int id){
        return iCarRegister.editCarDetails(carDto,id);
    }

}
