# Models - Encapsulation

## Models that ONLY KNOW things (DTOs)

A DTO is a Data Transfer Object - it's primary purpose is to KNOW things, so that you can pass that object around (similar to a struct in C++)

---

### Book

|variable|type|get|set| notes |
|--------|----|---|---|-------|
|title|String|public|public|       |
|isbn|String|public|public|       |
|author|String|public|public|       |
|pages|int|public|public|       |

---


### Person
|variable|type|get|set|notes|
|--------|----|---|---|-----|
|firstName|String|getFirstName()|setFirstName(String firstName)|
|lastName|String|getLastName()|setLastName(String lastName)|
|age|int|getAge()|setAge(int age)|
|*fullName*|String|getFullName()||this is a derived property (there is NO BACKING VARIABLE)

---

## Models that ONLY DO things (static classes)

Static classes DO NOT store any instance variables, everything function is static (global). Each function call has enough information to perform the entire task, so there is no need to store additional information

---

### Calculator

Note that there are NO variables or getters/setters.

```java
public static double add(double left, double right){...}

public static double subtract(double left, double right){...}

public static double multiply(double left, double right) {...}

public static double divide(double numerator, double denominator) {...}
```

---

## Models that KNOW AND DO things

All variables and functions should be closely related (they have high cohesion). This means that the variables in the class all relate to each other, and the functions in the class should operate on those instance variables.

---

### Pizza

|variable|type|get| set     |notes|
|--------|----|---|---------|-----|
|size|String|public| public  ||
|crust|String|public| public  ||
|sauce|String|public| public  ||
|toppings|List&lt;String&gt;|public| private ||
|price|double|public|         |Derived (calculated) property that calculates and returns the price of the pizza. (See details)|

#### Constructors

There should be 2 constructors. The default constructor sets the default pizza size, crust and sauce.

```java
public Pizza(){...}
public Pizza(String size, String crust, String sauce){...}
```

#### Derived Properties

##### price - this calculates the price (cost) of the pizza

* small = 9.99
* medium = 11.99
* large = 13.99

Each additional topping adds $1 to the cost of the pizza

#### Methods / Functions

##### addTopping

This method/function allows users to add toppings to the pizza.

```java
    public void addTopping(String topping){...}
```

##### removeTopping

This method/function allows users to remove a topping from the pizza.

```java
    public void removeTopping(String topping){...}
```

##### clearToppings

This method/function allows users to remove all toppings from the pizza.

```java
    public void clearToppings(){...}
```

---

### Mortgage

|variable|type|get| set     |notes|
|--------|----|---|---------|-----|
|principal|double|public| private |This is the original Loan amount|
|balance|double|public| private |This is the remaining balance on the loan|
|rate|double|public| private |The annual interest rate|
|term|int|public| private |The term of the loan (in years)|
|payments|int|public|         | Total number of payments. This is a derived property `term * 12` |
|monthlyPayment|double|public|         |This is a derived property that calculates the monthly payment (details below)|
|totalInterest|double|public|         | This is a derived property that calculates the total amount of interest paid (details below) |

#### Constructors

There should be 2 constructors that creates the mortgage with initial values:

```java
public Mortgage (double principal, int term, double rate){}

public Mortgage (double principal, int term, double rate, double remainingBalance){}
```

#### Derived Properties

##### `monthlyPayment` - derived property to calculate the monthly payment

$$monthlyPayment = \frac{principal * mir}{1 - (1 + mir)^{-payments}}$$

* **principal** = 100000
* **apr** = 6
* **rate** = .005 (6/1200)
* **term** = 30
* **payments** = 360 (30 * 12)

$$monthlyPayment = \frac{100000 * .005}{1 - (1 + .005)^{-360}}$$

$$monthlyPayment = \frac{500}{1 - .1660419}$$

$$monthlyPayment = \frac{500}{.8339581}$$

$$monthlyPayment = 599.55$$

##### `totalInterest` - a derived property that calculates the total amount of interest paid

$$ totalInterest = (montlyPayment * payments) - principal$$

$$ totalInterest = (599.55 * 360) - 100000$$

$$ totalInterest = (215838) - 100000$$

$$ totalInterest = 115838$$

#### Methods

There should be one method `pay(double amount)` which accepts an amount to be paid.

The method should calculate how much of the payment should be applied to the principal, and the subtract that amount from the principal.
