package com.techelevator;

public class Lecture {

    public static void main(String[] args) {
		
		/* Exercise 1
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
        int numberOfExercises = 26;

        System.out.println("1) Number of Exercises: " + numberOfExercises);
        System.out.println();


		/* Exercise 2
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
        double half = 0.5;

        System.out.println("2) Half: " + half);
        System.out.println();


		/* Exercise 3
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

        String name = "TechElevator";

        System.out.println("3) Name: " + name);
        System.out.println();


		/* Exercise 4
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
        int seasonsOfFirefly = 1;

        System.out.println("4) Seasons of Firefly: " + seasonsOfFirefly);
        System.out.println();


		/* Exercise 5
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
        String myFavoriteLanguage = "Java";

        System.out.println("5) Favorite language: " + myFavoriteLanguage);
        System.out.println();


		/* Exercise 6
		6. Create a variable called pi and set it to 3.1416.
		*/
        double pi = 3.1416;

        System.out.println("6) pi: " + pi);
        System.out.println();


		/* Exercise 7
		7. Create and set a variable that holds your name.
		*/
        String firstName = "Gregor";

        System.out.println("7) First name: " + firstName);
        System.out.println();



		/* Exercise 8
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
        int buttonsOnMyMouse = 8;

        System.out.println("8) Number of buttons: " + buttonsOnMyMouse);
        System.out.println();


		/* Exercise 9
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
        int percentBattery = 99;

        System.out.println("9) Percent Battery Life: " + percentBattery);
        System.out.println();


		/* Exercise 10
		10. Create an int variable that holds the difference between 121 and 27.
		*/
        int glassesOnTheShelf = 121;
        int numberOfGuests = 27;
        int numberOfGlassesRemaining = glassesOnTheShelf - numberOfGuests;

        System.out.println("10) number of glasses remaining: " + numberOfGlassesRemaining);
        System.out.println();


		/* Exercise 11
		11. Create a double that holds the addition of 12.3 and 32.1.

		A movie costs $12.30 and decent earbuds cost $32.10. You want to buy both.
		What is the total cost?
		*/
        double movieCost = 12.3;
        double earBudCost = 32.1;
        double totalCost = movieCost + earBudCost;

        System.out.println("11) The total for a movie + ear buds: $" + totalCost);
        System.out.println();


		/* Exercise 12
		12. Create a String that holds your full name.
		*/
        String fullName = "Gregor Dzierzon";

        System.out.println("12) Full Name: " + fullName);
        System.out.println();


		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
        String greeting = "Hello, " + fullName;

        System.out.println("13) Greeting: " + greeting);
        System.out.println();



		/*
		14. Add an " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
        fullName = fullName + " Esquire";

        System.out.println("14) Esquire: " + fullName);
        System.out.println();


		/* Exercise 15
		15. Now do the same as exercise 14, but use the += operator.
		*/
        fullName += " Esquire";

        System.out.println("15) Esquire2: " + fullName);
        System.out.println();


		/* Exercise 16
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
        String movie = "Saw";
        movie += 2;

        System.out.println("16) Saw2: " + movie);
        System.out.println();


		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
        movie += 0;

        System.out.println("17) Saw20: " + movie);
        System.out.println();


		/* Exercise 18
		18. What is 4.4 divided by 2.2?
		*/
        double fours = 4.4;
        double twos = 2.2;
        double differenceOfFoursAndTwos = fours / twos;

        System.out.println("18) Divide 4.4 / 2.2: " + differenceOfFoursAndTwos);
        System.out.println();


		/* Exercise 19
		19. What is 5.4 divided by 2?
		*/
        double fiveFour = 5.4;
        int two = 2;
        double doubleIntDivision = fiveFour / two;

        System.out.println("19) 5.4 / 2: " + doubleIntDivision);
        System.out.println();


		/* Exercise 20
		20. What is 5 divided by 2?
		*/
        int five = 5;
        int twoAgain = 2;
        double doubleDivisionFiveAndTwo = five / twoAgain;

        System.out.println("20) 5 / 2: " + doubleDivisionFiveAndTwo);
        System.out.println();


		/* Exercise 21
		21. What is 5.0 divided by 2?
		*/
        double fiveOh = 5.0;
        int anotherTwo = 2;
        double doubleIntDivisionFiveOhAndTwo = fiveOh / anotherTwo;

        System.out.println("21) 5.0 / 2: " + doubleIntDivisionFiveOhAndTwo);
        System.out.println();


		/* Exercise 22
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
        double sixSixSix = 66.6;
        int hundo = 100;
        double sixtySixPercent = sixSixSix / hundo;

        System.out.println("22) 66.6 / 100: " + sixtySixPercent);
        System.out.println();



		/* Exercise 23
		23. If I divide 5 by 2, what's my remainder?
		*/
        int fiveAgain = 5;
        int twoRemainder = 2;
        int remainder = fiveAgain % twoRemainder;

        System.out.println("23) 5 % 2: " + remainder);
        System.out.println();



		/* Exercise 24
		24. What is 1,000,000,000 * 3?
		*/
        long coolBillion = 1000000000;
        int accounts = 3;
        long totalRevenue = coolBillion * 3;

        System.out.println("24) 3 Billion: " + totalRevenue);
        System.out.println();



		/* Exercise 25
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
        boolean doneWithExercises = false;

        System.out.println("25) I am done! " + doneWithExercises);
        System.out.println();


		/*
		26. Now set doneWithExercise to true.
		*/
        doneWithExercises = !doneWithExercises;

        System.out.println("26) I am done! " + doneWithExercises);
        System.out.println();


    }

}
