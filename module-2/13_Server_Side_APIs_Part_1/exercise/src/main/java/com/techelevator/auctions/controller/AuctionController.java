package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController()
    {
        this.dao = new MemoryAuctionDao();
    }


    @GetMapping(path="")
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte)
    {
        List<Auction> auctions;

        if (title_like.length() > 0 && currentBid_lte == 0) auctions = dao.searchByTitle(title_like);
        else if (title_like.length() == 0 && currentBid_lte > 0) auctions = dao.searchByPrice(currentBid_lte);
        else if (title_like.length() > 0 && currentBid_lte > 0) auctions = dao.searchByTitleAndPrice(title_like, currentBid_lte);
        else auctions = dao.list();
        
        return auctions;
    }

    @GetMapping(path="/{id}")
    public Auction get(@PathVariable int id)
    {
        Auction auction = dao.get(id);
        return auction;
    }

    @PostMapping(path="")
    public Auction create(@RequestBody Auction auction)
    {
        Auction newAuction = dao.create(auction);
        return newAuction;
    }



}
