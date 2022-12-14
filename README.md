# Dice
### ***Java Console App to roll dice and flip coins***

![Untitled design (5)](https://user-images.githubusercontent.com/47723396/207472065-5bf7df9c-1126-4d6b-bad0-73658bfd97e8.png)

-----  
# DiceApp 
## Rolling Dice
Users can choose to roll one or multiple dice.
```java
if (numberOfTimesToRollDice == 1) Dice.rollOne(diceSelection);
if (numberOfTimesToRollDice > 1) Dice.rollMany(diceSelection, numberOfTimesToRollDice);
```   
    
## Flipping Coin
Users can also choose to flip one or multiple coins.   
```java
if (coinFlips == 1) Dice.flipOne();
if (coinFlips > 1) Dice.flipMany(coinFlips);
```   
   
-----
# Dice
## Rolling Dice
Uses Java's `ThreadLocalRandom` to get a random number between 1 and the highest possible roll (based on dice type).
```java
public static int getRoll(int diceType){
      return ThreadLocalRandom.current().nextInt(1, diceType + 1);
}
```   
If only rolling a single dice, the result is displayed.
```java 
public static void rollOne(int dice){
      // ... validation for entered dice type
      UserOutput.printRoll(getRoll(dice));
}
```   
If rolling multiple dice, each roll is printed on a new line, and then the sum total of all rolls is displayed. 
```java
public static void rollMany(int dice, int increment){
      // ... validation for entered dice type and number of times to roll dice
      int total = 0;
      for (int i = 1; i <= increment; i++) {
            int roll = getRoll(dice);
            UserOutput.printRoll(roll, i);
            total += roll;
      }
      UserOutput.printRollTotal(total);
}
```

## Flipping Coin
Calls the `getRoll` function to get a random number between 1 and 2 and assigns 'Heads' or 'Tails' based on the return.
```java
static final int COIN = 2;
public static String flipCoin( ){
      int randomNum = Dice.getRoll(COIN);
      return (randomNum == 1) ? "Heads" : "Tails";
}
``` 
If only flipping a single coin, the result is displayed.
```java
public static void flipOne(){
      // ...
      UserOutput.printFlip(flipCoin());
}
```   
If flipping multiple coins, each coin flip is printed on a new line, and the total for 'Heads' and 'Tails' is displayed. 
```java
public static void flipMany(int increment){
      // ... validation for number of times to flip coin
      int headsTotal = 0;
      int tailsTotal = 0;
      for (int i = 1; i <= increment; i++) {
            String flip = flipCoin();
            UserOutput.printFlip(flip, i);
            if (flip.equals("Heads")) headsTotal++;
            if (flip.equals("Tails")) tailsTotal++;
      }
      UserOutput.printFlipTotals(headsTotal, tailsTotal);
 }
 ```
     
## Validating User Input
The entered dice type must be a dice type commonly used used in tabletop RPG games (D4, D8, D10, D12, D20, & D100).
```java
// static finals created for each dice type
public static boolean validateDice(int dice){
      boolean isValid = (dice == D4 || 
                         dice == D6 || 
                         dice == D8 || 
                         dice == D10 || 
                         dice == D12 || 
                         dice == D20 || 
                         dice == D100);
      if (!isValid) UserOutput.printDiceTypeError(dice);
      return isValid;
}
```
If rolling multiple dice or flipping multiple coins, the entered number of times to roll dice or flip coins must be between 1 and 20.
```java
public static boolean validateIncrement(int type, int i){
      // set minimum and maximum values for increment
      int minimumIncrement = 1;
      int maximumIncrement = 20;

      boolean isValid = (i >= minimumIncrement && i <= maximumIncrement);
      if (!isValid && type == COIN) UserOutput.printFlipTimesError();
      if (!isValid && type != COIN) UserOutput.printRollTimesError();
      return isValid;
}
```   
     
![Untitled design (6)](https://user-images.githubusercontent.com/47723396/207473115-b1cf008e-8d58-4573-bd69-c7d6bd33622a.png)
     
   
-----
# User Input
Uses Java Scanner to take in user input from the console.   
Input string is stripped of leading and trailing whitespace and returned.
```java
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        String input = scanner.nextLine().strip();
        return input;
    }
}
```
    
-----
# User Output
Contains all the print statements used to display information to the console.    
Text printed to the console is formatted using Java's `String.format()` as well as final values set in the `FontColor` class.     
When rolling multiple dice, rolls are printed out in alternating white-grey-white pattern for easier reading.     
When flipping multiple coins, 'Heads' is printed out in white and 'Tails' in grey for easier reading.     
```java 
// FontColor.WHITE is dull white, FontColor.RESET is bright white
public static void printRoll(int roll, int i) {
      String increment = String.format("%2s", String.valueOf(i));
      String formattedRoll = String.format("%3s", String.valueOf(roll));
      if (i%2!=0) {
            System.out.println(FontColor.PURPLE + 
                               "Roll " + 
                               increment + 
                               ":   " + 
                               FontColor.RESET + 
                               formattedRoll);
      } else {
            System.out.println(FontColor.PURPLE + 
                               "Roll " + 
                               increment + 
                               ":   " + 
                               FontColor.WHITE + 
                               formattedRoll + 
                               FontColor.RESET);
      }
}
```
```java
public static void printFlip(String flip, int i) {
      String increment = String.format("%2s", i);
      if (flip.equals("Heads")) {
            System.out.println(FontColor.PURPLE + 
                               "Flip " + 
                               increment + 
                               ":   " + 
                               FontColor.RESET + 
                               flip);
      } else {
            System.out.println(FontColor.PURPLE + 
                              "Flip " + 
                              increment + 
                              ":   " + 
                              FontColor.WHITE + 
                              flip + 
                              FontColor.RESET);
      }
}
```
