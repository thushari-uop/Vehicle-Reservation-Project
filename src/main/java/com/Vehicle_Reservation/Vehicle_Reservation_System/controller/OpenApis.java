package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.DriverDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.PassengerDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.UserAuthDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.DriverService;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/open")
public class OpenApis {
    @Autowired
    DriverService driverService;
    @Autowired
    PassengerService passengerService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/add-driver")
    public boolean addDriver(@RequestBody DriverDto driverDto){
        driverService.addDriver(driverDto);
        return true;
    }

    @PostMapping("/add-passenger")
    public boolean addPassenger(@RequestBody PassengerDto passengerDto){
        passengerService.addPassenger(passengerDto);
        return true;
    }

    @PostMapping("{type}/login")
    public ApiResponse Login(@RequestBody UserAuthDto authDto, @PathVariable String type){
        String driver = "DRIVER";
        String passenger = "PASSENGER";
        if (driver.equalsIgnoreCase(type)) {
            return driverService.handleDriverLogin(authDto);
        }

        if (passenger.equalsIgnoreCase(type)) {
            return passengerService.handlePassengerLogin(authDto);

        }
        return null;
    }


}
