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
    public void coinExchange() {
    }
}
