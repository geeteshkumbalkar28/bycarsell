package com.SellBuyCar.controller;

import com.SellBuyCar.Interface.IUser;
import com.SellBuyCar.dto.*;
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
    public List<ResponseUserProfileDto> getAllUsers(@RequestParam int pageNo){
        return iuserProfile.getAllUsers(pageNo);

    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChange passwordChange){

        int id=passwordChange.getId();
        String password=passwordChange.getPassword();
        iuserProfile.changePassword(id,password);

        return  null;
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
