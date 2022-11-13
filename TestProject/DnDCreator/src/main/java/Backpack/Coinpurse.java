package Backpack;

import java.util.Map;

public class Coinpurse{

    final int COPPER = 1;
    final int SILVER = 10;
    final int ELECTRUM = 50;
    final int GOLD = 100;
    final int PLATINUM = 1000;

    // money - number of coins by type
    private int numberOfCopperCoins = 0;
    private int numberOfSilverCoins = 0;
    private int numberOfElectrumCoins = 0;
    private int numberOfGoldCoins = 0;
    private int numberOfPlatinumCoins = 0;
    private boolean useElectrum;

    public Coinpurse(int numberOfCopperCoins, int numberOfSilverCoins, int numberOfElectrumCoins, int numberOfGoldCoins, int numberOfPlatinumCoins) {
        this.numberOfCopperCoins = numberOfCopperCoins;
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.useElectrum = true;
        this.numberOfElectrumCoins = numberOfElectrumCoins;
        this.numberOfGoldCoins = numberOfGoldCoins;
        this.numberOfPlatinumCoins = numberOfPlatinumCoins;
    }

    public Coinpurse(int numberOfCopperCoins, int numberOfSilverCoins, int numberOfGoldCoins, int numberOfPlatinumCoins){
        this.numberOfCopperCoins = numberOfCopperCoins;
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.useElectrum = false;
        this.numberOfGoldCoins = numberOfGoldCoins;
        this.numberOfPlatinumCoins = numberOfPlatinumCoins;
    }

    public Coinpurse(boolean useElectrum){
        this.useElectrum = useElectrum;
    }

    public Coinpurse() {
    }


    // copper
    public int getNumberOfCopperCoins() {
        return numberOfCopperCoins;
    }
    public void setNumberOfCopperCoins(int numberOfCopperCoins) {
        this.numberOfCopperCoins = numberOfCopperCoins;
    }
    public void addCopperCoins(int numberOfCopperCoinsToAdd) {
        if (numberOfCopperCoinsToAdd > 0) numberOfCopperCoins += numberOfCopperCoinsToAdd;
    }
    public void subtractCopperCoins(int numberOfCopperCoinsToSubtract) {
        if (numberOfCopperCoinsToSubtract > 0) numberOfCopperCoins -= numberOfCopperCoinsToSubtract;
    }

    // silver
    public int getNumberOfSilverCoins() {
        return numberOfSilverCoins;
    }
    public void setNumberOfSilverCoins(int numberOfSilverCoins) {
        this.numberOfSilverCoins = numberOfSilverCoins;
    }
    public void addSilverCoins(int numberOfSilverCoinsToAdd) {
        if (numberOfSilverCoinsToAdd > 0) numberOfSilverCoins += numberOfSilverCoinsToAdd;
    }
    public void subtractSilverCoins(int numberOfSilverCoinsToSubtract) {
        if (numberOfSilverCoinsToSubtract > 0) numberOfSilverCoins -= numberOfSilverCoinsToSubtract;
    }

    // electrum
    public int getNumberOfElectrumCoins() {
        return numberOfElectrumCoins;
    }
    public void setNumberOfElectrumCoins(int numberOfElectrumCoins) {
        this.numberOfElectrumCoins = numberOfElectrumCoins;
    }
    public void addElectrumCoins(int numberOfElectrumCoinsToAdd) {
        if (numberOfElectrumCoinsToAdd > 0 && useElectrum) numberOfElectrumCoins += numberOfElectrumCoinsToAdd;
    }
    public void subtractElectrumCoins(int numberOfElectrumCoinsToSubtract) {
        if (numberOfElectrumCoinsToSubtract > 0 && useElectrum) numberOfElectrumCoins -= numberOfElectrumCoinsToSubtract;
    }
    public void setUseElectrum(boolean useElectrum){
        this.useElectrum = useElectrum;
    }

    // gold
    public int getNumberOfGoldCoins() {
        return numberOfGoldCoins;
    }
    public void setNumberOfGoldCoins(int numberOfGoldCoins) {
        this.numberOfGoldCoins = numberOfGoldCoins;
    }
    public void addGoldCoins(int numberOfGoldCoinsToAdd) {
        if (numberOfGoldCoinsToAdd > 0) numberOfGoldCoins += numberOfGoldCoinsToAdd;
    }
    public void subtractGoldCoins(int numberOfGoldCoinsToSubtract) {
        if (numberOfGoldCoinsToSubtract > 0) numberOfGoldCoins -= numberOfGoldCoinsToSubtract;
    }

    // platinum
    public int getNumberOfPlatinumCoins() {
        return numberOfPlatinumCoins;
    }
    public void setNumberOfPlatinumCoins(int numberOfPlatinumCoins) {
        this.numberOfPlatinumCoins = numberOfPlatinumCoins;
    }
    public void addPlatinumCoins(int numberOfPlatinumCoinsToAdd) {
        if (numberOfPlatinumCoinsToAdd > 0) numberOfPlatinumCoins += numberOfPlatinumCoinsToAdd;
    }
    public void subtractPlatinumCoins(int numberOfPlatinumCoinsToSubtract) {
        if (numberOfPlatinumCoinsToSubtract > 0) numberOfPlatinumCoins -= numberOfPlatinumCoinsToSubtract;
    }

    public int getTotalCoinValueInCopper() {

        int copperValue = numberOfCopperCoins;
        int silverValue = numberOfSilverCoins * SILVER;
        int electrumValue = numberOfElectrumCoins * ELECTRUM;
        int goldValue = numberOfGoldCoins * GOLD;
        int platinumValue = numberOfPlatinumCoins * PLATINUM;
        return copperValue + silverValue + electrumValue + goldValue + platinumValue;
    }

    public void printTotalValueInCopper() {
        int totalValueInCopper = getTotalCoinValueInCopper();
        System.out.println("Total value of your coinpurse (in copper): " + totalValueInCopper);
    }

    public int getItemCostInCopper(int copper, int silver, int electrum, int gold, int platinum){
        silver *= SILVER;
        electrum *= ELECTRUM;
        gold *= GOLD;
        platinum *= PLATINUM;
        return copper + silver + electrum + gold + platinum;
    }

    public void printItemCostInCopper(int copper, int silver, int electrum, int gold, int platinum){
        int costInCopper = getItemCostInCopper(copper, silver, electrum, gold, platinum);
        System.out.println("Total cost of item (in copper): " + costInCopper);
    }

    public void spendMoney(int itemCostInCopper){
        int originalMoneyTotal = getTotalCoinValueInCopper();
        if (itemCostInCopper < originalMoneyTotal && itemCostInCopper > 0) {
            int newMoneyTotal = originalMoneyTotal - itemCostInCopper;
            condenseCoinage(newMoneyTotal);
            System.out.println("Sold!");
            System.out.println("Your coinpurse now contains: ");
            System.out.println("----------------------------");
            System.out.println(numberOfPlatinumCoins + " platinum coins");
            System.out.println(numberOfGoldCoins + " gold coins");
            if (useElectrum) System.out.println(numberOfElectrumCoins + " electrum coins");
            System.out.println(numberOfSilverCoins + " silver coins");
            System.out.println(numberOfCopperCoins + " copper coins");
            System.out.println();
        } else {
            int coppersShort = originalMoneyTotal - itemCostInCopper;
            System.out.println("You do not have enough money to spend this amount.");
            System.out.println("You are " + coppersShort + " copper coins short.");
        }
    }

    public void earnMoney(int amountGainedInCopper) {
        if (amountGainedInCopper > 0) {
            int originalMoneyTotal = getTotalCoinValueInCopper();
            int newMoneyTotal = originalMoneyTotal + amountGainedInCopper;
            condenseCoinage(newMoneyTotal);
        }
    }

    public void coinExchange() {
        int totalValue = getTotalCoinValueInCopper();
        condenseCoinage(totalValue);
    }

    public void condenseCoinage(int totalValue) {
        int numberPlatinum = totalValue / PLATINUM;
        int valueAfterPlatinum = totalValue % PLATINUM;
        int numberGold = valueAfterPlatinum / GOLD;
        int valueAfterGold = valueAfterPlatinum % GOLD;
        int numberElectrum = 0;
        int valueAfterElectrum;
        int numberSilver;
        int valueAfterSilver;
        if (useElectrum) {
            numberElectrum = valueAfterGold / ELECTRUM;
            valueAfterElectrum = valueAfterGold % ELECTRUM;
            numberSilver = valueAfterElectrum / SILVER;
            valueAfterSilver = valueAfterElectrum % SILVER;
        } else {
            numberSilver = valueAfterGold / SILVER;
            valueAfterSilver = valueAfterGold % SILVER;
        }
        // numberCopper = valueAfterSilver;

        this.numberOfPlatinumCoins = numberPlatinum;
        this.numberOfGoldCoins = numberGold;
        if (useElectrum) this.numberOfElectrumCoins = numberElectrum;
        this.numberOfSilverCoins = numberSilver;
        this.numberOfCopperCoins = valueAfterSilver;
    }

    public void convertCoins(int givenCoin, int coinAmount, int toCoin){
        int givenValueInCopper = coinAmount * givenCoin;
        if (givenValueInCopper < toCoin) System.out.println("Cannot convert! (insufficient funds given)");
        int numberToCoin = givenValueInCopper/toCoin;
        int remaining = givenValueInCopper%toCoin / givenCoin;
    }
}
