package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public Bid getHighBid() {
        if (super.getHighBid().getBidAmount() < reservePrice) {
            return new Bid("", 0);
        } else {
            return super.getHighBid();
        }
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isHighBidder = super.placeBid(offeredBid);

        return (offeredBid.getBidAmount() < reservePrice) ? false : isHighBidder;
    }
}
