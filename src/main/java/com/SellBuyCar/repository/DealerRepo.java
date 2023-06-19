package com.SellBuyCar.repository;

import com.SellBuyCar.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepo extends JpaRepository<Dealer,Integer>{
    public Dealer findByEmail(String email);
}
