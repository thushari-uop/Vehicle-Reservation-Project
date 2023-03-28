package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String Address;
    private String telephone;
    private String licenceNo;
    private LocalDate dob;
    private String email;
}
