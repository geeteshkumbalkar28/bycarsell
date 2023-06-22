package com.SellBuyCar.repository;

import com.SellBuyCar.model.Userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserprofileRepo extends JpaRepository<Userprofile,Integer> {

   @Modifying
   @Query(value = "DELETE FROM buysellcar.userprofile WHERE user_profile_id=:user_id", nativeQuery = true)
   public void DeleteById(int user_id);



}
