package com.techelevator;

public class SilentAuction extends Auction {

    public SilentAuction(String itemsForSale) {
        super(itemsForSale);
    }

    @Override
    public Bid getHighBid() {
        return new Bid("", 0);
    }

    public Bid getWinningBid() {
        return super.getHighBid();
    }
}
