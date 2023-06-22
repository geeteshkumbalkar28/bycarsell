package com.SellBuyCar.Interface;


import com.SellBuyCar.dto.CarDto;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface ICarRegister {
    public String AddCarDetails(CarDto carDto);
    public String editCarDetails(CarDto carDto,int id);
    public List<CarDto> getAllCarsWithPages(int PageNo);
    public String deleteCar(int id);


}
