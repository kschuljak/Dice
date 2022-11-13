package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    /* not weekend: 40 <= successful <= 60
        is weekend: 40 <= successful (no upper limit)
     */
    public final boolean WEEKEND = true;
    public final boolean NOT_WEEKEND = false;
    CigarParty cigarParty = new CigarParty();

    @Before
    public void setUp() {
        cigarParty = new CigarParty();
    }

    @Test
    public void haveParty_Should_ReturnTrue_given61CigarsAndWeekend() {

        //arrange
        int cigars = 61;

        //act
        boolean actual = cigarParty.haveParty(cigars, WEEKEND);

        //assert
        assertTrue("Because there is no upper limit for cigars on weekends", actual);
    }

    @Test
    public void haveParty_Should_ReturnFalse_given61CigarsAndNotWeekend() {

        //arrange
        int cigars = 61;

        //act
        boolean actual = cigarParty.haveParty(cigars, NOT_WEEKEND);

        //assert
        assertFalse("Because the upper limit for cigars is 60 when not weekend", actual);
    }

    @Test
    public void haveParty_Should_ReturnFalse_given39CigarsAndWeekend() {

        //arrange
        int cigars = 39;

        //act
        boolean actual = cigarParty.haveParty(cigars, WEEKEND);

        //assert
        assertFalse("Because the lower limit for cigars is always 40", actual);
    }

    @Test
    public void haveParty_Should_ReturnFalse_given39CigarsAndNotWeekend() {

        //arrange
        int cigars = 39;

        //act
        boolean actual = cigarParty.haveParty(cigars, WEEKEND);

        //assert
        assertFalse("Because the lower limit for cigars is always 40", actual);
    }

    @Test
    public void haveParty_Should_ReturnTrue_given40CigarsAndWeekend() {

        //arrange
        int cigars = 40;

        //act
        boolean actual = cigarParty.haveParty(cigars, WEEKEND);

        //assert
        assertTrue("Because the lower limit for cigars is always 40 (inclusive)", actual);
    }

    @Test
    public void haveParty_Should_ReturnTrue_given40CigarsAndNotWeekend() {

        //arrange
        int cigars = 40;

        //act
        boolean actual = cigarParty.haveParty(cigars, NOT_WEEKEND);

        //assert
        assertTrue("Because the lower limit for cigars is always 40 (inclusive)", actual);
    }

    @Test
    public void haveParty_Should_ReturnTrue_given60CigarsAndNotWeekend() {

        //arrange
        int cigars = 60;

        //act
        boolean actual = cigarParty.haveParty(cigars, NOT_WEEKEND);

        //assert
        assertTrue("Because the upper limit for cigars is 60 (inclusive) when not weekend", actual);
    }

    @Test
    public void haveParty_Should_ReturnFalse_givenNegative60CigarsAndWeekend() {

        //arrange
        int cigars = -60;

        //act
        boolean actual = cigarParty.haveParty(cigars, WEEKEND);

        //assert
        assertFalse("Because a negative number is still below the minimum limit for cigars", actual);
    }

    @Test
    public void haveParty_Should_ReturnFalse_givenVariableDefaultValuesAtInstantiation() {

        //arrange
        int intDefault = 0;
        boolean booleanDefault = false;

        //act
        boolean actual = cigarParty.haveParty(intDefault, booleanDefault);

        //assert
        assertFalse("Because default int 0 and default boolean false, 0 is less than lower limit for cigars", actual);
    }
}
