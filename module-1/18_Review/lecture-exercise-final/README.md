# Week 4 Review

This review exercise is intended to help you solidify the concepts that we have covered throughout Module 1, and to prepare you for the module 1 capstone project. 

## Step One: Getting started

* `Program.java` is the entry of the application.
* The project has been split into 3 main packages which organize all classes into their respective categories (based on responsibility)
* **application** - this contains the main application class and overall application logic
  * `Store.java` is the main application class.
* **models** - this is where all of the classes live which make up the business logic of the application. They are the building blocks for the application. The primary classes are:
  * `Inventory.java` 
  * `ShoppingCart.java` 
  * `CashRegister.java` 
  * Other support classes include:
    * `InsufficientFundsException.java` - this class extends `Exception` and is used when the user tries to check out. If the payment amount is not enough to cover the cost of the shopping cart total.
    * `Logger.java` is used to as a logging engine - it can be used for general information or for error logging.
    * `FileProductLoader.java` is responsible for reading the products.csv file and converting it to a list of products
    * `FileReceiptPrinter.java` is used to generate a receipt text file which contains the details of the purchased products.
* **ui** - is the package where all user interaction should occur. It is made up of 2 classes
  * `UserInput.java` for when you need to prompt and receive input from the user
  * `UserOutput.java` for when you need to display information to the user
* `TELogException.java` extends `RuntimeException` and reports `TELog`-specific exceptions. You'll implement `TELog` in this exercise.

Test data files are provided for your convenience. They're located under the `data` folder.

## Step Two: Create the general flow of the application

Write code in the `Store.java` class to manage the flow of the application. In other words, create a flow that allows the user to walk through the application __*screens*__ while displaying dummy data


* Main/Home Page Options
  * Add Product to Cart
  * View Cart
  * Check Out
* Add Product to Cart Page
  * (display product inventory)
  * *Options*
    * Select product number/id
    * Cancel
* View Cart Page
  * (display items in the cart)
  * (display cart total)
  * *Options*
    * back
* Checkout Page
  * (display cart total)
  * Prompt for payment amount:


## Step Three: Implement the `Inventory` logic

Use the `FileProductLoader` to load all products in the data/products.csv file into a List or Map in the Inventory class.

The products should be loaded as soon as a new Inventory instance is created (constructor).

Use the loaded inventory to display all products in the Add Products to Cart page.

## Step Four: Implement the `ShoppingCart` logic

The shopping cart should allow the user to add any of the products to the cart.

The cart should allow the user have more than one or each item by tracking the quantity of each product. If the same product is added more than once, the cart should not add the same product again, rather it should update the quantity. This is most easily accomplished by using a `Map<Product,Integer>`.

Implement the getCartTotal() derived property by calculating the total cost of all the products. (Don't forget about the quantity of each product)

## Step Five: Implement the `CashRegister` class

We need to allow the user to check out. The `CashRegister` class has one method, the `pay` method. It accepts as input the current shopping cart, and the amount that the user is paying.

The `pay` method should return the amount of change that is due to the customer.

If the money provided to the `pay` method is not enough to cover the cost of the ShoppingCart, then an InsufficientFundsException should be thrown.

## Step Six: Implement the `Logger` class

The logger class should log any error messages to the errors log file. 

Since the CashRegister's pay method will potentially throw an exception, you will want to log that error.

Complete the code in the `Logger` class to log the error.

In the `Store` class, when you make a call to the CashRegister.pay method, catch the error, and pass the error message to the Logger.logMessage() method.

## Bonus: Implement the `FileReceiptPrinter` class

After the user has paid and checked out, the application should generate a receipt file.

Use the `FileReceiptPrinter` class to generate that receipt. The createReceipt method should loop through the items in the shopping cart and add each product as a line item to the receipt. 

At the end of the receipt you should aslo display the total amount, the cash tendered, and the change given



### Avoid repeatedly opening and closing log file

Repeatedly opening and closing files is very expensive in terms of performance and can significantly slow an application. The search application is small enough that it doesn't really matter, but there is a technique you can use to handle the problem.

Rather than always creating a new instance of `PrintWriter` in the `log()` method, move the local `PrintWriter` variable out of the method, and make it a `static` class variable. Then, in the method, check if the variable is `null`. If it is, create an instance of `PrintWriter` and assign it to the class variable. The next time the `log()` method is called, the class variable is no longer `null`, and the method can use the existing instance of `PrintWriter` to write the message.

> Note: replace any call to the `PrintWriter`'s `close()` method with a call to the `flush()` method. This way, the file can be kept open and the log message written with each call. Also, the `append` argument `true` can be removed from `new FileOutputStream("logs/search.log")` if you'd like to start with a fresh log each time the application runs.

### Use `LocalDate`/`LocalDateTime` in Logger and FileReceiptPrinter clases

Log files can grow lengthy over time. Knowing the date and time when a message was logged is almost always critical during debugging. Log file names are also usually date or date-time based.

The Java `LocalDate` and `LocalDateTime` classes are the standards for working with dates and times. Introductory tutorials are available at:

[LocalDate](https://docs.oracle.com/javase/tutorial/datetime/iso/date.html)
[LocalDateTime](https://docs.oracle.com/javase/tutorial/datetime/iso/datetime.html)
[Date and Time Parsing and Formatting](https://docs.oracle.com/javase/tutorial/datetime/iso/format.html)

Modify the `FileOutputStream` filename parameter to use `LocalDate` instead of hard-coding `logs/search.log`.

Add a date-time stamp to the log message using `LocalDateTime`.

> Hint: `DateTimeFormatter.ISO_DATE` and `DateTimeFormatter.ISO_DATE_TIME` are useful for building a valid log filename and date-time stamping the message.
