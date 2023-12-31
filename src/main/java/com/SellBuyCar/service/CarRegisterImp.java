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
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service
public class CarRegisterImp implements ICarRegister {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DealerRepo dealerRepo;



    @Override
    public String AddCarDetails(CarDto carDto) {
        System.out.println(carDto.getDealer_id());
        Optional<Dealer> dealer=dealerRepo.findById(carDto.getDealer_id());
        System.out.println(dealer.toString());
        List<Car> dealerCar = null;
          if (dealer.isPresent()){

              Car car =new Car(carDto);
              car.setDealer(dealer.get());
              dealerCar=dealer.get().getCars();

              dealer.get().setCars(dealerCar);
              dealerRepo.save(dealer.get());
              carRepo.save(car);
              return "car Added";

          }

//        System.out.println("4");

//        byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
//        String encryptPassword=new String(encrypt);

      return "invalid Id";

    }

    @Override
    public String editCarDetails(CarDto carDto, int id) {
        System.err.println(carDto.getCarStatus()+""+id);
        Optional<Car> carDetails = carRepo.findByid(id);
        System.err.println(carDetails.get().getArea());

        if (carDetails.isPresent()){
            System.err.println("44");
            Car car = new Car(carDto);
        try{
//            carRepo.flush();
            carRepo.save(car);
            return "Car Updated"+id;

        } catch (Exception e){
            System.err.println("yes :"+e);
        }

            }
        return "invalid Id"+id;
    }

    @Override
    public List<CarDto> getAllCarsWithPages(int PageNo) {
        return null;
    }

    @Override
    public String deleteCar(int id) {
        Optional<Car> car = carRepo.findById(id);
        if(car.isPresent()){
            try {
                carRepo.deleteById(id);
                return "car Delete Succesfully :"+ id;
            }catch (Exception e){
                System.err.println(e);
            }

        }
        return "id invalid";
    }
}
