package com.techelevator;

public class Demo_Dining {

    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;
    private static final int WEDNESDAY = 3;
    private static final int THURSDAY = 4;
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;

    public static void main(String[] args) {

        String location = whereShouldIEat(SATURDAY, 4, 15);

        System.out.println("You should eat at " + location);

    }

    // on Tuesdays (2) I eat at Costa Vida
    // on Wednesdays (3) I eat at Papa Johns
    // every other day I eat at home
  
    public static String whereShouldIEat(int dayOfTheWeek) {
        if (dayOfTheWeek == TUESDAY) {
            return "Costa Vida";
        } else if (dayOfTheWeek == WEDNESDAY) {
            return "Papa Johns";
        } else {
            return "Home";
        }
    }

    // on Tuesdays (2) I eat at Costa Vida
    // on Wednesdays (3) I eat at Papa Johns
    // but only if I have at least $20
    // every other day I eat at home
    public static String whereShouldIEat(int dayOfTheWeek, double availableCash) {
        if (availableCash >= 20) {
            return whereShouldIEat(dayOfTheWeek);
            /*
            if (dayOfTheWeek == TUESDAY) {
                return "Costa Vida";
            } else if (dayOfTheWeek == WEDNESDAY) {
                return "Papa Johns";
            } else {
                return "Home";
            }
            */
        } else {
            return "home";
        }
    }

    /*
    ratings:
    1 - $5
    2 - $10
    3 - $20
    4 - $30+

    eat out if I have enough cash to eat at chosen restaurant
        -if not eat at home
    unless it's the weekend - then always eat out
    */
    public static String whereShouldIEat(int dayOfTheWeek, int restaurantRating, double availableCash) {

        double price;
        if (restaurantRating == 4) {
            price = 30;
        } else if (restaurantRating == 3) {
            price = 20;
        } else if(restaurantRating == 2) {
            price = 10;
        } else {
            price = 5;
        }

        boolean isWeekend = dayOfTheWeek == SATURDAY || dayOfTheWeek == SUNDAY;
        boolean hasEnoughCash = availableCash >= price;

        if (isWeekend) {
            return "the restaurant";
        } else {
            if (hasEnoughCash) {
                return "the restaurant";
            }
        }
        return "home";
    }

    public static String whereShouldIEat(int dayOfTheWeek, int restaurantRating, double availableCash, boolean getCashIfNeeded) {
        return "";
    }
}
