package com.SellBuyCar.repository;

import com.SellBuyCar.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
    public Optional<Car> findByid(int id);
    @Modifying
    @Query(value = "DELETE FROM buysellcar.car WHERE car_id=:car_id", nativeQuery = true)
    public void DeleteById(int car_id);

}
