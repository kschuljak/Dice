package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController
{
    HotelDao hotelDao;
    ReservationDao reservationDao;

    public ReservationController()
    {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

//    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
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


    // // we CANNOT use a GetMapping for a path that has already been mapped
//    @GetMapping(path="/reservations")
//    public List<Reservation> getResvervationsByHotelId(Integer hotelId)
//    {
//        List<Reservation> reservations = reservationDao.findByHotel(hotelId);
//
//        return reservations;
//    }

}
