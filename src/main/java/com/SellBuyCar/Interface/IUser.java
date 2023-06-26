package com.SellBuyCar.Interface;

import com.SellBuyCar.dto.DealerDto;
import com.SellBuyCar.dto.ResponseDealerDto;
import com.SellBuyCar.dto.ResponseUserProfileDto;
import com.SellBuyCar.dto.UserProfileDto;
import com.SellBuyCar.model.Userprofile;

import javax.transaction.Transactional;
import java.util.List;

public interface IUser {


    String editUser(UserProfileDto userProfileDto, int id);

    String removeUser(int id);

    List<ResponseUserProfileDto> getAllUsers(int pageNo);

    void changePassword(int id,String password);
}

