package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.HotelSearchFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryHotelDao implements HotelDao {

    /**
     * We are using a static variable here because this DAO is used by the hotel
     * controller and the MemoryReservationDao and they need to share the same data.
     * This is where we would normally reach for dependency injection but because we
     * haven't learned about it yet we are using this workaround.
     */
    private static List<Hotel> hotels = new ArrayList<>();

    public MemoryHotelDao() {
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
                "Aloft Cleveland",
                new Address("1111 W 10th St","","Cleveland","Ohio","44115"),
                4,
                48,274));
        hotels.add(new Hotel(2,
                "Hilton Cleveland Downtown",
                new Address("100 Lakeside Ave","","Cleveland","Ohio","44114"),
                4,
                12,287));
        hotels.add(new Hotel(3,
                "Metropolitan at the 9",
                new Address("2017 E 9th St","","Cleveland","Ohio","48226"),
                5,
                22,319));
        hotels.add(new Hotel(4,
                "The Westin Pittsburgh",
                new Address("1000 Penn Ave","","Pittsburgh","Pennsylvania","15222"),
                4,
                60,131));
        hotels.add(new Hotel(5,
                "Hilton Columbus Downtown",
                new Address("401 N High St","","Columbus","Ohio","43215"),
                4,
                34,190));
        hotels.add(new Hotel(6,
                "The Summit A Dolce Hotel",
                new Address("5345 Medpace Way","","Cincinnati","Ohio","43215"),
                4,
                43,218));
        hotels.add(new Hotel(7,
                "Greektown Detroit",
                new Address("1200 St Antoine St","","Detroit","Michigan","48226"),
                4,
                75,185));
    }
}
