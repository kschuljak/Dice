# Dice - ***Java Console App to roll dice and flip coins***
   
## DiceApp 
### Rolling Dice
Users can choose to roll one or multiple dice.
```java
if (numberOfTimesToRollDice == 1) Dice.rollOne(diceSelection);
if (numberOfTimesToRollDice > 1) Dice.rollMany(diceSelection, numberOfTimesToRollDice);
```   
### Flipping Coin
Users can also choose to flip one or multiple coins.   
```java
if (coinFlips == 1) Dice.flipOne();
if (coinFlips > 1) Dice.flipMany(coinFlips);
```   
   
## Dice
### Rolling Dice
Uses Java's `ThreadLocalRandom` to get a random number between 1 and given value for dice type.   
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

### Flipping Coin
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
     
### Validating User Input
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
