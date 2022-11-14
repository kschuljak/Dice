package Backpack.Coinpurse;

public class CoinConversion {

    final int COPPER = 1;
    final int SILVER = 10;
    final int ELECTRUM = 50;
    final int GOLD = 100;
    final int PLATINUM = 1000;

    public void convertCoins(int givenCoin, int coinAmount, int wantedCoin){
        int givenValueInCopper = coinAmount * givenCoin;
        if (givenValueInCopper < wantedCoin) System.out.println("Cannot convert! (insufficient funds given)");
        int numberConverted = givenValueInCopper/wantedCoin;
        int remaining = (givenValueInCopper%wantedCoin)/givenCoin;
        System.out.println("Number of converted coins: " + numberConverted);
        System.out.println("Number of original coins remaining: " + remaining);
    }


}
