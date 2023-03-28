package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReservationDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Reservation;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservatinService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void addReservation(ReservationDto reservationDto){
        reservationRepository.save(modelMapper.map(reservationDto, Reservation.class));
    }

    public List<ReservationDto> getAllReservations(){
        List<Reservation>reservationList = reservationRepository.findAll();
        return modelMapper.map(reservationList,new TypeToken<List<ReservationDto>>(){}.getType());
    }

    public boolean cancelReservation(Integer reservationId){
        reservationRepository.deleteById(reservationId);
        return true;
    }

    public ReservationDto getReservationByReservationId(Integer reservationId){
        Reservation reservation = reservationRepository.getReferenceById(reservationId);
        return modelMapper.map(reservation,ReservationDto.class);
    }
}
