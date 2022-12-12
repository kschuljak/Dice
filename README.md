# Dice - ***Java Console App to roll dice and flip coins***
   
## DiceApp
Users can choose to roll one or multiple dice, of types D4, D6, D10, D12, D20, & D100.   
(*If rolling multiple, the sum total of all rolls is displayed.*)   
```java
if (numberOfTimesToRollDice == 1) Dice.rollOne(diceSelection);
if (numberOfTimesToRollDice > 1) Dice.rollMany(diceSelection, numberOfTimesToRollDice);
```   

Users can also choose to flip one or multiple coins.   
(*If flipping multiple, a results total for heads and tails is displayed.*)   
```java
if (coinFlips == 1) Dice.flipOne();
if (coinFlips > 1) Dice.flipMany(coinFlips);
```   
