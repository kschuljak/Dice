package com.techelevator;

public class Exercise02_CanDrive {

    /*
    The problems below ask you to implement the correct logic to answer
    whether someone is allowed to drive based on the provided parameters.
    NOTE: These rules are loosely based off of the real world
    and may be different from the state you live in.
     */

    /*
    A person can drive if they have a permit and are with a licensed passenger.
    Given two boolean values, hasPermit and withLicensedPassenger,
    write an expression that is true if a person can drive.

    Examples:
    canDrive(true, true) ➔ true
    canDrive(true, false) ➔ false
    canDrive(false, true) ➔ false
    canDrive(false, false) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger) {
        return false;
    }

    /*
    In some states, the licensed passenger must be of a certain age.
    Implement the logic to return true if the person has a permit and is with a licensed passenger who is 21 or over.

    Examples:
    canDrive(true, true, 22) ➔ true
    canDrive(true, true, 19) ➔ false
    canDrive(false, true, 23) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger, int passengerAge) {
        return false;
    }

    /*
    If the licensed passenger is the driver's legal guardian, they only have to be 18 instead of 21.
    Implement the logic to return true if the person has a permit and is with a licensed passenger.
    The licensed passenger only needs to be 18 or older if they're the driver's guardian. Otherwise, the passenger must be 21 or older.

    Examples:
    canDrive(true, true, 22, false) ➔ true
    canDrive(true, true, 19, true) ➔ true
    canDrive(false, true, 23, true) ➔ false
     */
    public boolean canDrive(boolean hasPermit, boolean withLicensedPassenger, int passengerAge, boolean isPassengerOurGuardian) {
        return false;
    }
}
