package Backpack.Shop;

import Backpack.Coinpurse.Coinpurse;

public interface Shoppable {

    void buy(Shoppable item, Coinpurse coinpurse);
    void sell (Shoppable item, Coinpurse coinpurse);

}
