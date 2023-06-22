package com.SellBuyCar.service;

import com.SellBuyCar.Interface.IUser;
import com.SellBuyCar.dto.ResponseUserProfileDto;
import com.SellBuyCar.dto.UserProfileDto;
import com.SellBuyCar.model.Userprofile;
import com.SellBuyCar.repository.UserprofileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileImpl implements IUser {

    @Autowired
    private UserprofileRepo userprofileRepo;

    @Override
    public List<ResponseUserProfileDto> getAllUsers(int pageNo) {
        List<Userprofile> listOfUsers = userprofileRepo.findAll();
        System.out.println("list of User"+listOfUsers.size());
        List<ResponseUserProfileDto> listOfUserDto = new ArrayList<>();
//        System.out.println("2");
        int pageStart=pageNo*25;
        int pageEnd=pageStart+25;
        int diff=(listOfUsers.size()) - pageStart;

        for(int counter=pageStart,i=1;counter<pageEnd;counter++,i++){
            if(pageStart>listOfUsers.size()){break;}

            System.out.println("*");
            ResponseUserProfileDto responseUserDto = new ResponseUserProfileDto(listOfUsers.get(counter));

            listOfUserDto.add(responseUserDto);

            if(diff == i){
                break;
            }
        }

        System.out.println(listOfUserDto);
        return listOfUserDto;

    }

    @Override
    public String editUser(UserProfileDto userProfileDto, int id) {

        Optional<Userprofile> user = userprofileRepo.findById(id);
        if(user.isPresent()){
            user.get().setFirstName(userProfileDto.getFirstName());
            user.get().setLastName(userProfileDto.getLastName());
            user.get().setAddress(userProfileDto.getAddress());
            user.get().getUser().setMobileNo(userProfileDto.getMobile_no());
            byte encrypt[]= Base64.getEncoder().encode(userProfileDto.password.getBytes());
            String encryptPassword=new String(encrypt);
            user.get().getUser().setPassword(encryptPassword);

            user.get().getUser().setEmail(userProfileDto.getEmail());
            user.get().setCity(userProfileDto.getCity());

            userprofileRepo.save(user.get());
            return "User Details Edited of id No= :"+id;
        }
        return "invalid id";
    }


    @Override
    @Transactional
    public String removeUser(int id) {
        Optional<Userprofile> dealer = userprofileRepo.findById(id);
        if(dealer.isPresent()){
            try {
                userprofileRepo.DeleteById(id);
                return "dealer Delete Successfully :"+ id;
            }catch (Exception e){
                System.err.println(e);
            }

        }
        return "id invalid";
    }
}
