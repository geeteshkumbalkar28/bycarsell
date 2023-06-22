package com.SellBuyCar.controller;

import com.SellBuyCar.Interface.IUser;
import com.SellBuyCar.dto.DealerDto;
import com.SellBuyCar.dto.ResponseDealerDto;
import com.SellBuyCar.dto.ResponseUserProfileDto;
import com.SellBuyCar.dto.UserProfileDto;
import com.SellBuyCar.repository.UserprofileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUser iuserProfile;

    @GetMapping("/getAllUsers")
    public List<ResponseUserProfileDto> getAllDealer(@RequestParam int pageNo){
        return iuserProfile.getAllUsers(pageNo);

    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@RequestBody UserProfileDto userProfileDto, @PathVariable int id){
        iuserProfile.editUser(userProfileDto,id);
        return ResponseEntity.status(HttpStatus.OK).body(iuserProfile.editUser(userProfileDto,id));

    }
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUser(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(iuserProfile.removeUser(id));

    }
}
