package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationsController
{
    HotelDao hotelDao;
    ReservationDao reservationDao;

    public ReservationsController()
    {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    @GetMapping(path="/reservations")
    public List<Reservation> getAllReservations(@RequestParam Integer hotelId)
    {

        List<Reservation> reservations;
        if(hotelId != null)
        {
            reservations = reservationDao.findByHotel(hotelId);
        }
        else
        {
            reservations= reservationDao.findAll();
        }

        return reservations;
    }

    @GetMapping(path= "/reservations/{id}")
    public Reservation getReservationById(@PathVariable int id)
    {
        Reservation reservation = reservationDao.get(id);

        return reservation;
    }

}
