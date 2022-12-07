package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController
{

    HotelDao hotelDao;
    ReservationDao reservationDao;


    public ReservationController()
    {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

//  @RequestMapping(path="", method=RequestMethod.GET)
//  - same as @GetMapping(path="")
    @GetMapping(path="")
    public List<Reservation> getAllReservations()
    {
        List<Reservation> reservations = reservationDao.findAll();
        return reservations;
    }

    // @PathVariable argument has to be a compatible data type to the requested data
    @GetMapping(path="/{id}")
    public Reservation getReservationById(@PathVariable int id)
    {
        Reservation reservation = reservationDao.get(id);
        return reservation;
    }






    // !!!!! CANNOT USE GetMapping FOR A PATH THAT HAS ALREADY BEEN MAPPED !!!!!

    /*
    // when using a query string, you need a nullable data type
    // in Java, Integer is nullable, int is not nullable
    @GetMapping(path="")
    public List<Reservation> getReservations(@RequestParam Integer hotelId)
    {
        List<Reservation> reservations;
        if (hotelId != null) {
            reservations = reservationDao.findByHotel(hotelId);
        } else {
            reservations = reservationDao.findAll();
        }
        return reservations;
    }
     */
}
