package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.HotelSearchFilter;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController
{

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelsController()
    {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Returns a list of all searched hotels
     *
     * @param filter - HotelSearchFilter - contains all possible query string parameters
     * @return
     */
    @GetMapping(path = "")
    public List<Hotel> searchHotels(HotelSearchFilter filter)
    {
        List<Hotel> hotels = hotelDao.search(filter);

        return hotels;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @GetMapping(path = "/{id}")
    public Hotel get(@PathVariable int id)
    {
        return hotelDao.get(id);
    }

    @GetMapping(path = "{hotelId}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable int hotelId)
    {
        List<Reservation> reservations = reservationDao.findByHotel(hotelId);
        return reservations;
    }


    @PostMapping(path = "{hotelId}/reservations")
    public Reservation addReservation(@PathVariable int hotelId, @RequestBody Reservation reservation)
    {
        Reservation newReservation = reservationDao.create(reservation, hotelId);
        return newReservation;
    }

    @GetMapping("filter")
    public List<Hotel> searchForHotels(@RequestParam String state, @RequestParam(required = false) String city)
    {
        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> list = hotelDao.list();

        for (Hotel hotel : list)
        {
            if (city != null)
            {
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())
                        && hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase()))
                {
                    filteredHotels.add(hotel);
                }
            }
            else
            {
                if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase()))
                {
                    filteredHotels.add(hotel);
                }
            }
        }

        return filteredHotels;
    }


}
