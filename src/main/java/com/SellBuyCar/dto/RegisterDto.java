package com.SellBuyCar.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {


    public String address;

    private String city;

    private String firstName;

    private String lastName;
    private String email;

    private String mobileNo;

    private String password;
}
