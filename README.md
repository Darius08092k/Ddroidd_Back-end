# Ddroidd_Back-end
Hello, 
This is my solution for the stated requirements

I started off by creating a class named "Item". 
This class represented every item from the specified inventory, meaning it must contain all the variables to store the given values. (name: String, price:double, weight:double, country:String)
I created a constructor with every variable specified above, and also getters and setters.

Another class was the "Products" one, where i created objects based on the "Items" class, putting in every given value in its correct place.
I used and ArrayList where i stored every object previously created, and the printed it on the screen.
I created a method which will print for the user a counter for everytime an item was selected, and everytime after selecting an item, the user was asked if a new item will be inserted.
If the user chose "y" the program will run again and need to select an item from the list printed above.
If the user chose "n" the program will call another methods wich will compute the Subtotal, Shipping, VAT, Discounts, and Total.

The first method, for computing the total, every item is multiplied by its counter, and the price.

The second method, for computing the shipping, I created a new class "ShippingRate" which had the country for every product, and how much it costs/0.1 kg to ship from that country
In this method, i added into a total value the weight of the product multiplied by the counter, and the shipping rate. I also had to add a multiplication by 10, in order to get the actual price.

The thrid method, which checked if the sum of every counter is greater or equal than 2, the total shipping will have a -10$ value.

The fourth method, which checked if the counter for the keyboard is different from 0, if the value is true, then the price of the keyboard will be multiplied by its counter,
and by 0.1 since it had a 10% discount for every keyboard.

I computed the total of the picked items by using operations with the returned values from these methods.

The user needs to:
- write the actual name of a product from the list, or else the program will crash
- write either "y" or "n" when selecting the new item addition.
