alert ("Hello World!");

//get 3 inputs and parse to Ints
let amount = parseInt(prompt("What is the cost of the room?"), 10);
let taxRate = parseInt(prompt("What is the tax rate?"),10);
let rooms = parseInt(prompt("How many rooms do you want to book?"),10);

//calculate total, to 2 decimal places using toFixed
let total = ((amount * rooms) + ((taxRate/100) * (amount * rooms))).toFixed(2);

//target table IDs and output values entered and total.
document.getElementById("amount").innerHTML = "$"+ amount;
document.getElementById("taxrate").innerHTML = taxRate + "%";
document.getElementById("rooms").innerHTML = rooms;
document.getElementById("total").innerHTML = "$" + total;


