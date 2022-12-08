package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReservationsController
{
    HotelDao hotelDao;
    ReservationDao reservationDao;

    @Autowired
    public ReservationsController(HotelDao hotelDao, ReservationDao reservationDao)
    {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    @GetMapping(path="/reservations")
    public List<Reservation> getAllReservations(@RequestParam(required = false) Integer hotelId)
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

    @PutMapping(path= "/reservations/{id}")
    public void updateReservation(@PathVariable int id, @Valid @RequestBody Reservation reservation)
    {
        Reservation currentReservation = reservationDao.get(id);

        if(currentReservation == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation id " + id + " was not found.");
        }

        reservationDao.update(id, reservation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/reservations/{id}")
    public void deleteReservation(@PathVariable int id)
    {
        Reservation currentReservation = reservationDao.get(id);

        if(currentReservation == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation id " + id + " was not found.");
        }

        reservationDao.delete(id);
    }

}
