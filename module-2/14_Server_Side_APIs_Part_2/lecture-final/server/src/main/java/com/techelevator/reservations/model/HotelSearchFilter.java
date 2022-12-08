package com.techelevator.reservations.model;

import org.springframework.web.bind.annotation.RequestParam;

public class HotelSearchFilter
{
    private String name;
    private Integer stars;
    private Double cost;
    private String city;
    private String state;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if(name != null)
        {
            this.name = name.toLowerCase();
        }
    }

    public boolean hasName()
    {
        return name != null;
    }

    public Integer getStars()
    {
        return stars;
    }

    public void setStars(Integer stars)
    {
        this.stars = stars;
    }

    public boolean hasStars()
    {
        return stars != null;
    }

    public Double getCost()
    {
        return cost;
    }

    public void setCost(Double cost)
    {
        this.cost = cost;
    }

    public boolean hasCost()
    {
        return cost != null;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        if(city != null)
        {
            this.city = city.toLowerCase();
        }
    }

    public boolean hasCity()
    {
        return city != null;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        if(state != null)
        {
            this.state = state.toLowerCase();
        }
    }

    public boolean hasState()
    {
        return state != null;
    }
}
