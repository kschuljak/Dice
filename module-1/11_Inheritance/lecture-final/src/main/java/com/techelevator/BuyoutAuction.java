package com.techelevator;

public class BuyoutAuction extends Auction
{

    private int buyNowAmount;
    private boolean isClosed;

    public BuyoutAuction(String itemForSale, int buyNowAmount)
    {
        // call the constructor of the parent
        // THIS IS REQUIRED
        // it MUST be the first call in the constructor
        super(itemForSale);

        this.buyNowAmount = buyNowAmount;
    }

    @Override
    public boolean placeBid(Bid offeredBid)
    {
        if(!isClosed)
        {
            if (offeredBid.getBidAmount() >= buyNowAmount)
            {
                Bid newBid = new Bid(offeredBid.getBidder(), buyNowAmount);
                isClosed = true;

                return super.placeBid(newBid);
            }

            return super.placeBid(offeredBid);
        }
        return false;
    }
}
