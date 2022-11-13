package Backpack;

import static org.junit.Assert.*;

public class CoinpurseTest {

    final int COPPER = 1;
    final int SILVER = 10;
    final int ELECTRUM = 50;
    final int GOLD = 100;
    final int PLATINUM = 1000;
    final boolean USE_ELECTRUM = true;
    final boolean NO_ELECTRUM = false;


    @org.junit.Test
    public void getTotalCoinValueInCopper_Should_Return1161_GivenOneOfEach_AndUsingElectrum() {

        //arrange
        Coinpurse coinpurse = new Coinpurse(1, 1, 1, 1, 1);
        boolean useElectrum = USE_ELECTRUM;
        int expected = 1161;

        //act
        int actual = coinpurse.getTotalCoinValueInCopper();

        //assert
        assertEquals("Because 1 PP (1000 CP) + 1 GP (100 CP) + 1 EP (50 CP) + 1 SP (10 CP) + 1 CP = 1161 CP total", expected, actual);
    }

    @org.junit.Test
    public void getTotalCoinValueInCopper_Should_Return1111_GivenOneOfEach_AndNoElectrum() {

        //arrange
        Coinpurse coinpurse = new Coinpurse(1, 1, 0, 1, 1);
        boolean useElectrum = NO_ELECTRUM;
        int expected = 1111;

        //act
        int actual = coinpurse.getTotalCoinValueInCopper();

        //assert
        assertEquals("Because 1 PP (1000 CP) + 1 GP (100 CP) + 1 SP (10 CP) + 1 CP = 1111 CP total", expected, actual);
    }

    @org.junit.Test
    public void coinExchange_ShouldReturn_OnePlatinum_Given10Gold() {

        //arrange
        Coinpurse coinpurse = new Coinpurse(0, 0, 0, 10, 0);
        int expectedCopper = 0;
        int expectedSilver = 0;
        int expectedElectrum = 0;
        int expectedGold = 0;
        int expectedPlatinum = 1;
        int[] expectedValues = new int[]{expectedCopper, expectedSilver, expectedElectrum, expectedGold, expectedPlatinum};

        //act
        coinpurse.coinExchange();
        int actualCopper = coinpurse.getNumberOfCopperCoins();
        int actualSilver = coinpurse.getNumberOfSilverCoins();
        int actualElectrum = coinpurse.getNumberOfElectrumCoins();
        int actualGold = coinpurse.getNumberOfGoldCoins();
        int actualPlatinum = coinpurse.getNumberOfPlatinumCoins();
        int[] actualValues = new int[]{actualCopper, actualSilver, actualElectrum, actualGold, actualPlatinum};

        //assert
        assertArrayEquals("Because return should maximize coin of highest value to minimize total number of coins", expectedValues, actualValues);
    }

    @org.junit.Test
    public void coinExchange_ShouldReturn_MaximumNumberOfHighestCoinByValue() {

        //arrange
        Coinpurse coinpurse = new Coinpurse(1482, 92, 0, 100, 2);
        coinpurse.setUseElectrum(USE_ELECTRUM);
        coinpurse.addElectrumCoins(52);

        int expectedCopper = 2;
        int expectedSilver = 0;
        int expectedElectrum = 0;
        int expectedGold = 0;
        int expectedPlatinum = 17;
        int[] expectedValues = new int[]{expectedCopper, expectedSilver, expectedElectrum, expectedGold, expectedPlatinum};

        //act
        coinpurse.coinExchange();
        int actualCopper = coinpurse.getNumberOfCopperCoins();
        int actualSilver = coinpurse.getNumberOfSilverCoins();
        int actualElectrum = coinpurse.getNumberOfElectrumCoins();
        int actualGold = coinpurse.getNumberOfGoldCoins();
        int actualPlatinum = coinpurse.getNumberOfPlatinumCoins();
        int[] actualValues = new int[]{actualCopper, actualSilver, actualElectrum, actualGold, actualPlatinum};

        //assert
        assertArrayEquals("Because return should maximize coin of highest value to minimize total number of coins", expectedValues, actualValues);
    }
}
