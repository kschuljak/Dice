package com.techelevator;

public class ReserveAuction extends Auction
{
    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice)
    {
        super(itemForSale);

        this.reservePrice = reservePrice;
    }

    @Override
    public Bid getHighBid()
    {
        // if the reserve has not been met
        // then there is no high bidder
        if(super.getHighBid().getBidAmount() < reservePrice)
        {
            return new Bid("", 0);
        }
        else
        {
            return super.getHighBid();
        }
    }

    @Override
    public boolean placeBid(Bid offeredBid)
    {
        boolean isHighBiddeer = super.placeBid(offeredBid);

        // even if they are the high bidder
        // if they didn't meet the reserve they
        // are not the winning bidder
        if(offeredBid.getBidAmount() < reservePrice)
        {
            return false;
        }

        return isHighBiddeer;
    }
}
