package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Driver;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Vehicle;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void addDriver(DriverDto driverDto){
        driverRepository.save(modelMapper.map(driverDto,Driver.class));
    }

    public List<DriverDto> getAllDrivers(){
        List<Driver>driverList = driverRepository.findAll();
        return modelMapper.map(driverList,new TypeToken<List<DriverDto>>(){}.getType());
    }

    public void deleteDriverById(Integer driverId){
        driverRepository.deleteById(driverId);
    }

    public DriverDto getDriverByDriverId(Integer driverId){
        Driver driver = driverRepository.getReferenceById(driverId);
        return modelMapper.map(driver,DriverDto.class);
    }

    public void updateDriverDetails(String userName, String firstName, String lastName, String userName1, String password, String address, String telephone, String licenceNo, LocalDate dob, String email) {

        Driver driver = driverRepository.getDriverByUserName(userName);

        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setUserName(userName1);
        driver.setPassword(password);
        driver.setAddress(address);
        driver.setTelephone(telephone);
        driver.setLicenceNo(licenceNo);
        driver.setDob(dob);
        driver.setEmail(email);
    }

    public List<Vehicle> getVehiclesByUserName(String userName) {
        Driver driver = driverRepository.getDriverByUserName(userName);
        return driver.getVehicles();
//        return modelMapper.map(driver.getVehicles(),new TypeToken<List<VehicleDto>>(){}.getType());
    }

}