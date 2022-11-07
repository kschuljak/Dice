package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyNowAmount;

    public BuyoutAuction(String itemForSale, int buyNowAmount) {
        // call parent constructor - REQUIRED
        super(itemForSale);
        this.buyNowAmount = buyNowAmount;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if(!isClosed) {
            if (offeredBid.getBidAmount() >= buyNowAmount) {
                Bid newBid = new Bid(offeredBid.getBidder(), buyNowAmount);
                return super.placeBid(newBid);
            }
            return super.placeBid(offeredBid);
        }
    }
}
