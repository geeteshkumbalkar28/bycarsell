package com.SellBuyCar.service;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import com.SellBuyCar.model.Car;
import com.SellBuyCar.model.Carphoto;
import com.SellBuyCar.model.Dealer;
import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.CarRepo;
import com.SellBuyCar.repository.DealerRepo;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarRegisterImp implements ICarRegister {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DealerRepo dealerRepo;



    @Override
    public String AddCarDetails(CarDto carDto) {
        Optional<Dealer> dealer=dealerRepo.findById(carDto.getDealer_id());
          if (dealer.isPresent()){

              Car car =new Car(carDto);
              car.setDealer(dealer.get());

              carRepo.save(car);
//              dealerRepo.save(dealerData);
              return "car Added";

          }

//        System.out.println("4");

//        byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
//        String encryptPassword=new String(encrypt);

      return "invalid Id";

    }

    @Override
    public String editCarDetails(CarDto carDto, int id) {
        return null;
    }

    @Override
    public List<CarDto> getAllCarsWithPages(int PageNo) {
        return null;
    }

    @Override
    public String deleteCar(int id) {
        return null;
    }
}
