package Backpack.Shop;

import Backpack.Coinpurse.*;
import Backpack.Gear.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    protected int shopFundsInCopper = 150000;
    protected String[] gearInShop = new String[]{};
    protected Map<Integer, Gear> gearMap = new HashMap<>();

    public int getShopFundsInCopper() {
        return shopFundsInCopper;
    }
    public void setShopFundsInCopper(int shopFundsInCopper) {
        this.shopFundsInCopper = shopFundsInCopper;
    }

    public String[] getGearInShop() {
        return gearInShop;
    }
    public void setGearInShop(String[] gearInShop) {
        this.gearInShop = gearInShop;
    }

    public Map<Integer, Gear> getGearMap() {
        return gearMap;
    }
    public void setGearMap(Map<Integer, Gear> gearMap) {
        this.gearMap = gearMap;
    }
}

/*
Print list of Shoppable gear options
If user selects an option
Check if coinpurse contains enough money to purchase
& if yes, subtract cost of item from coinpurse (& recalculate coin totals)
& Create an instance of that class and add to backpack's packed gear list (of Gear objects)
& add value of item to shop funds



 */
