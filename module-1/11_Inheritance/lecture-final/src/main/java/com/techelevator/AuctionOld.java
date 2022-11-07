package com.techelevator;

import java.util.ArrayList;
import java.util.List;

// this is the Auction BEFORE we implemented inheritance
public class AuctionOld
{

    private String itemForSale;
    private Bid currentHighBid;
    private List<Bid> allBids;
    private boolean isSilentAuction;
    private boolean isBuyNowAuction;
    private int buyNowAmount;

    private boolean isClosed = false;

    public AuctionOld(String itemForSale)
    {
        this.itemForSale = itemForSale;
        this.currentHighBid = new Bid("", 0);
        allBids = new ArrayList<>();
    }

    public AuctionOld(String itemForSale, int buyNowAmount)
    {
        // calling the other constructor
        // MUST BE the first call in the constructor
        this(itemForSale);

        this.buyNowAmount = buyNowAmount;
        this.isBuyNowAuction = true;
    }

    public AuctionOld(String itemForSale, boolean isSilentAuction)
    {
        this(itemForSale);

        this.isSilentAuction = isSilentAuction;
    }

    public boolean placeBid(Bid offeredBid)
    {
        allBids.add(offeredBid);
        boolean isCurrentWinningBid = false;

        if(isBuyNowAuction)
        {
            if(!isClosed)
            {
                if(offeredBid.getBidAmount() >= buyNowAmount)
                {
                    isClosed = true;
                    Bid newBid = new Bid(offeredBid.getBidder(), buyNowAmount);
                    currentHighBid = newBid;
                }
                else if(offeredBid.getBidAmount() > currentHighBid.getBidAmount())
                {
                    currentHighBid = offeredBid;
                    isCurrentWinningBid = true;
                }
            }
        }
        else if(!isSilentAuction)
        {
            if (offeredBid.getBidAmount() > currentHighBid.getBidAmount())
            {
                currentHighBid = offeredBid;
                isCurrentWinningBid = true;
            }
        }
        return isCurrentWinningBid;
    }

    public Bid getHighBid()
    {
        return currentHighBid;
    }

    public Bid getWinningBid()
    {
        if(!isSilentAuction) return currentHighBid;

        Bid winner = currentHighBid;

        for (Bid bid : allBids)
        {
            if(bid.getBidAmount() > winner.getBidAmount())
            {
                winner = bid;
            }
        }

        return winner;
    }


    public List<Bid> getAllBids()
    {
        return new ArrayList<>(allBids);
    }

    public String getItemForSale()
    {
        return itemForSale;
    }
}
