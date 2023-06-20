package com.SellBuyCar.service;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import com.SellBuyCar.model.Car;
import com.SellBuyCar.model.Carphoto;
import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.CarRepo;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRegisterImp implements ICarRegister {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public String AddCarDetails(CarDto carDto) {

        Car car=new Car(carDto);
//        Carphoto carphoto=new Carphoto();


        carRepo.save(car);
        return "Added Car data";
    }
}
