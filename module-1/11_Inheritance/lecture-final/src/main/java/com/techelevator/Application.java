package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        BuyoutAuction buyNowAuction = new BuyoutAuction("Calculator Watch (80's)",15);
        SilentAuction silentAuction = new SilentAuction("Tech Elevator backpack");
        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Laptop", 1000);

        generalAuction.placeBid(new Bid("Josh", -1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Daniel", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
//        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        System.out.println("Winner General Auction: " + generalAuction.getHighBid().getBidder());
        System.out.println("$" + generalAuction.getHighBid().getBidAmount());

        buyNowAuction.placeBid(new Bid("Josh", 1));
        buyNowAuction.placeBid(new Bid("Daniel", 23));
        buyNowAuction.placeBid(new Bid("Fonz", 50));

        System.out.println();

        System.out.println("Number of bidders: " + buyNowAuction.getAllBids().size());
        System.out.println("Winner Buy Now Auction: " + buyNowAuction.getHighBid().getBidder());
        System.out.println("$" + buyNowAuction.getHighBid().getBidAmount());



        silentAuction.placeBid(new Bid("Josh", 1));
        silentAuction.placeBid(new Bid("Quinn", 123));
        silentAuction.placeBid(new Bid("Fonz", 100));

        System.out.println();

        System.out.println("Winner Silent Auction: " + silentAuction.getHighBid().getBidder());
        System.out.println("$" + silentAuction.getHighBid().getBidAmount());

        System.out.println("Winner Silent Auction: " + silentAuction.getWinningBid().getBidder());
        System.out.println("$" + silentAuction.getWinningBid().getBidAmount());


        reserveAuction.placeBid(new Bid("Josh", 1));
        reserveAuction.placeBid(new Bid("Daniel", 23));
        reserveAuction.placeBid(new Bid("Fonz", 50));
        reserveAuction.placeBid(new Bid("Vanessa", 800));

        System.out.println();

        System.out.println("Number of bidders: " + reserveAuction.getAllBids().size());
        System.out.println("High bidder on Reserve: " + reserveAuction.getHighBid().getBidder());
        System.out.println("$" + reserveAuction.getHighBid().getBidAmount());

        reserveAuction.placeBid(new Bid("Fonz", 1050));
        reserveAuction.placeBid(new Bid("Vanessa", 1200));

        System.out.println("Number of bidders: " + reserveAuction.getAllBids().size());
        System.out.println("High bidder on Reserve: " + reserveAuction.getHighBid().getBidder());
        System.out.println("$" + reserveAuction.getHighBid().getBidAmount());


    }
}
