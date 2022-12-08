package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.HotelSearchFilter;

import java.util.List;

public interface HotelDao {

    List<Hotel> list();
    List<Hotel> search(HotelSearchFilter filter);

    void create(Hotel hotel);

    Hotel get(int id);

}
