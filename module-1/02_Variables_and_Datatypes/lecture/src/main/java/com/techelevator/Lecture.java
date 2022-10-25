package com.techelevator;

import java.sql.SQLOutput;

public class Lecture {

	public static void main(String[] args) {
		
		/* Exercise 1
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises;
		numberOfExercises = 26;

		System.out.println("1. Number of Exercises = " + numberOfExercises);
		System.out.println("1. expected value = 26");
		System.out.println();


		/* Exercise 2
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;

		System.out.println("2. Half = " + half);
		System.out.println("2. expected value = 0.5");
		System.out.println();

		/* Exercise 3
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";

		System.out.println("3. Name = " + name);
		System.out.println("3. expected value = TechElevator");
		System.out.println();


		/* Exercise 4
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println("4. Seasons of Firefly = " + seasonsOfFirefly);
		System.out.println("4. expected value = 1");
		System.out.println();


		/* Exercise 5
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";

		System.out.println("5. My favorite language = " + myFavoriteLanguage);
		System.out.println("5. expected value = Java");
		System.out.println();


		/* Exercise 6
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;

		System.out.println("6. Pi = " + pi);
		System.out.println("6. expected value = 3.1416");
		System.out.println();



		/* Exercise 7
		7. Create and set a variable that holds your name.
		*/
		String myName = "Katherine";

		System.out.println("7. My Name = " + myName);
		System.out.println("7. expected value = Katherine");
		System.out.println();


		/* Exercise 8
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMouse = 8;

		System.out.println("8. Number of buttons on my mouse = " + numberOfButtonsOnMouse);
		System.out.println("8. expected value = 8");
		System.out.println();


		/* Exercise 9
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentageOfPhoneBatteryRemaining = 98;

		System.out.println("9. Percentage of phone battery remaining = " + percentageOfPhoneBatteryRemaining);
		System.out.println("9. expected value = 98");
		System.out.println();


		/* Exercise 10
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int totalNumberOfSeats = 121;
		int numberOfGuests = 27;
		int numberOfSeatsRemaining = totalNumberOfSeats - numberOfGuests;

		System.out.println("10. Number of Seats Remaining = " + numberOfSeatsRemaining);
		System.out.println("10. expected value = 94");
		System.out.println();


		/* Exercise 11
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double ouncesOfDarkRoast = 12.3;
		double ouncesOfLightRoast = 32.1;
		double totalOuncesOfCoffee = ouncesOfDarkRoast + ouncesOfLightRoast;

		System.out.println("11. Total Ounces of Coffee = " + totalOuncesOfCoffee);
		System.out.println("11. expected value = 44.4");
		System.out.println();

		/* Exercise 12
		12. Create a String that holds your full name.
		*/
		String myFirstName = "Katherine";
		String myLastName = "Schuljak";
		String myFullName = myFirstName + " " + myLastName;

		System.out.println("12. My full name = " + myFullName);
		System.out.println("12. expected value = Katherine Schuljak");
		System.out.println();


		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, ";
		String helloToMe = hello + myFullName;

		System.out.println("13. Hello to me = " + helloToMe);
		System.out.println("13. expected value = Hello, Katherine Schuljak");
		System.out.println();

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		String myNameEsquire = myFullName + " Esquire";

		System.out.println("14. My Name Esquire = " + myNameEsquire);
		System.out.println("14. expected value = Katherine Schuljak Esquire");
		System.out.println();

		/* Exercise 15
		15. Now do the same as exercise 14, but use the += operator.
		*/
		String fullNameEsquire = "Katherine Schuljak";
		fullNameEsquire += " Esquire";

		System.out.println("15. My Name Esquire v2 = " + fullNameEsquire);
		System.out.println("15. expected value = Katherine Schuljak Esquire");

		/* Exercise 16
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw";
		String sequel = "2";
		String sequelToSaw = saw + sequel;

		System.out.println("16. Sequel to Saw = " + sequelToSaw);
		System.out.println("16. expected value = Saw2");
		System.out.println();




		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		String addAZero = "0";
		String the20thSaw = sequelToSaw + addAZero;

		System.out.println("17. Saw2 + 0 = " + the20thSaw);
		System.out.println("17. expected value = Saw20");
		System.out.println();

		/* Exercise 18
		18. What is 4.4 divided by 2.2?
		*/
		double dividend = 4.4;
		double divisor = 2.2;
		double quotient = dividend/divisor;

		System.out.println("18. Quotient = " + quotient);
		System.out.println("18. expected value = 2");
		System.out.println();


		/* Exercise 19
		19. What is 5.4 divided by 2?
		*/
		double wallsToPaint = 5.4;
		double wallsPaintedPerHour = 2;
		double totalHoursToPaintWalls = wallsToPaint/wallsPaintedPerHour;

		System.out.println("19. How long to paint walls = " + totalHoursToPaintWalls);

		/* Exercise 20
		20. What is 5 divided by 2?
		*/



		/* Exercise 21
		21. What is 5.0 divided by 2?
		*/



		/* Exercise 22
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/



		/* Exercise 23
		23. If I divide 5 by 2, what's my remainder?
		*/



		/* Exercise 24
		24. What is 1,000,000,000 * 3?
		*/



		/* Exercise 25
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/



		/*
		26. Now set doneWithExercise to true.
		*/
		boolean doneWithExercise = true;

		
	}

}
