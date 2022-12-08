package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.HotelSearchFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class MemoryHotelDao2 implements HotelDao {

    /**
     * We are using a static variable here because this DAO is used by the hotel
     * controller and the MemoryReservationDao and they need to share the same data.
     * This is where we would normally reach for dependency injection but because we
     * haven't learned about it yet we are using this workaround.
     */
    private static List<Hotel> hotels = new ArrayList<>();

    public MemoryHotelDao2() {
        if (hotels.size() == 0) {
            setHotels();
        }
    }

    @Override
    public Hotel get(int id) {
        for (Hotel hotel : hotels) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    @Override
    public List<Hotel> list() {
        return hotels;
    }

    @Override public List<Hotel> search(HotelSearchFilter filter)
    {
        List<Hotel> hotelList = new ArrayList<>();

        // filter for name
        for(Hotel hotel : hotels)
        {
            if (!filter.hasName() || hotel.getName().toLowerCase().contains(filter.getName()))
            {
                hotelList.add(hotel);
            }
        }

        var filteredList = hotels.stream()
                                            .filter(h -> !filter.hasName() || h.getName().toLowerCase().contains(filter.getName()))
                                            .filter(h -> !filter.hasStars() || h.getStars() >= filter.getStars())
                                            .filter(h -> !filter.hasCost() || h.getCostPerNight() <= filter.getCost())
                                            .filter(h -> !filter.hasCity() || h.getAddress().getCity().toLowerCase().equals(filter.getCity()))
                                            .filter(h -> !filter.hasState() || h.getAddress().getState().toLowerCase().equals(filter.getState()))
                                            .collect(Collectors.toList());
        
        return filteredList;
    }

    @Override
    public void create(Hotel hotel) {
        hotels.add(hotel);
    }


    private void setHotels() {
        hotels.add(new Hotel(1,
                "Marriott Downtown SLC",
                new Address("123 S Main St","","Salt Lake City","Utah","84111"),
                4,
                48,274));
    }
}
