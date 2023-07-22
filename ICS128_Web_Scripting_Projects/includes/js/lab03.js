//Excercise 1.1

//create counter function that takes a string and a char to count
function counter(string, char) {

    let count = 0;
    for (let i = 0; i <= string.length; i++) {
       let element = string[i];
       if (element == char) {
          count++;
       }
    }
    return count;
 }
 //create generic getInputValue method that takes an ID as param and returns the value of that element
 function getInputValue(idname) {
    let inputElement = document.getElementById(idname).value;
    // console.log(inputElement);
    return inputElement;
 }
 let btn1 = document.getElementById('btnSpaces');
 let btn2 = document.getElementById('btnLetters');
 
 let out1 = document.getElementById('spaces');
 let out2 = document.getElementById('letters');
 
 btn2.addEventListener('click', function () {
    let a = (counter(getInputValue('name'), getInputValue('letter')));
    out2.innerHTML = `There are <span style = "color: red;"> ${a} </span> ${getInputValue('letter')} in the string!`;
 })
 btn1.addEventListener('click', function () {
    let a = (counter(getInputValue('name'), ' '));
    out1.innerHTML = `There are <span style = "color: red;"> ${a} </span> spaces in the client's name`;
 })
 
 //Excercise 1.2 - using javascript Date Functions
 // var labDay = new Date(2022, 2, 1);
 // console.log(`labDay is ${labDay}`);
 // console.log(labDay.toDateString());
 // console.log(labDay.toTimeString());
 // console.log(`labDay as UTC is ${labDay.getTime()}`)
 // console.log(labDay.getDate() + " / " + labDay.getMonth() + " / " + labDay.getFullYear());
 // console.log(labDay.getHours() + " : " + labDay.getMinutes());
 // var now = Date.now();
 // console.log(now);
 // var errorDate = new Date(2016, 33, 1);
 // console.log(errorDate);
 // var invalidDate = new Date("Funuary 3, 2018");
 // console.log(invalidDate);
 // //declare variable options and assign it the object literal:
 // var options = { weekday: 'long' , year: 'numeric', month: 'long', day: 'numeric' };
 // console.log(labDay.toLocaleDateString('de-DE', options));
 // var msDay = (24*60*60*1000);
 // var mslabDay = now;
 // labDay = new Date(mslabDay + msDay);
 // console.log(labDay);
 
 //Pulling it all together
 var btn = document.getElementById('btnWage');
 var dateInput = document.getElementById('date');
 var dateOutput = document.getElementById('dateP');
 var daysOutput = document.getElementById('daysP');
 var workDaysOutput = document.getElementById('workDaysP');
 var wageOutput = document.getElementById('minWageP');
 var salaryOutput = document.getElementById('salaryP');
 
 function daysInMonth(year, month) { // Use 1 for Jan, 2 for Feb, etc.
    return new Date(year, month + 1, 0).getDate();
 }
 //make function to count work days, in javascript Sunday is 0
 function workDays(days, date) {
    let count = 0;
    let day = date.getDate();
    // console.log(`day: ${day}`);
    const msDay = 24 * 60 * 60 * 1000;
    let currentDay = date;
    // console.log(`currentDay: ${currentDay}`);
 
    for (let i = day; i <= days; i++) {
       //if day = 1-5 (weekday) add 1 to counter
    //    console.log(currentDay.getDay());
       if (currentDay.getDay() >= 1 && currentDay.getDay() <= 5) {
          count++;
          // console.log(`COUNTED`)
       }
       //add one day by adding msDay to current day time.
       currentDay = new Date(currentDay.getTime() + msDay);
       //   console.log(currentDay);
    }
 
    return count;
 }
 
 
 btn.addEventListener('click', function () {
    var inputValue = dateInput.value;
    // console.log(`INPUT VALUE: ${inputValue}`)
    var inputDate = Date.parse(inputValue);
    var date = new Date((inputDate));
    //adjust time for timeZone offset, date was being set to 1 day earlier than inputDate value
    date.setMinutes(date.getMinutes() + date.getTimezoneOffset());
    // console.log(date);
    // console.log(date.getUTCHours());
 
    // console.log(`original date value: ${date}`);
 
    // console.log(date.toTimeString());
    var wage = parseFloat(document.getElementById('wage').value).toFixed(2);
    //add 1 to month output as they are zero indexed
    dateOutput.innerHTML = `The Date you have selected: <span style= "color: red"> ${(date.getDate() + "-" + (date.getMonth()+1) + "-" + date.getFullYear())}</span>`;
    var days = daysInMonth(date.getFullYear(), date.getMonth());
    daysOutput.innerHTML = `How many days in a month: ${days}`
    workDaysOutput.innerHTML = `How many work days: ${workDays(days, date)}`;
    wageOutput.innerHTML = `BC Minimum Wage: <span style = "color: green"> $${wage} </span>`;
 
    var salary = (wage * workDays(days, date) * 8).toFixed(2);
    salaryOutput.innerHTML = `Salary for the Month (8hrs): <span style = 'color:red'> $${salary}</span>`;
 });

 //Part 2: Javascript Error Handling
 let p1 = document.getElementById('p1');
 let p2 = document.getElementById('p2');
 let p3 = document.getElementById('black');
 let check = document.getElementById('check');

 function isItInRange(input) {
    if (input <= 0) {
        throw new Error("The Value must be zero or greater");
    } else if (input <= 2) {
        throw new Error("The value is less than 2: " + input);
    } else if (input > 2) {
        throw new Error("The value is over 2: " + input);
    } else if (input >= 4) {
        throw new Error("Your value is in the correct range");
    }
}
check.addEventListener('click', function(){
    try {
        var input = parseInt(document.getElementById('errorInput').value);
        isItInRange(input);
        p1.innerHTML = `Your number value is: ${input}`;
        p3.innerHTML = "<span style='color: red'>Your Number is in the Correct Range</span>";
    } catch (error) {
        if (error.message === "The Value must be zero or greater") {
            p1.innerHTML = `Your number value is: ${input}`;
            p2.innerHTML = "Your number value is less than 2: <span style='color: blue'>" + input + "</span>";
            p3.innerHTML = "<span style='color: red'>Your Number: </span>" + input + "<span style = 'color: red'> must be greater than Zero</span>";
        } else if (error.message === "The value is less than 2: " + input) {
            p1.innerHTML = `Your number value is: ${input}`;

            p2.innerHTML = "Your number value is less than 2: <span style='color: blue'>" + input + "</span>";
            p3.innerHTML = "<span style='color: red'>Your Number: </span>" + input + "<span style = 'color: red'> must be greater than 2</span>";
        } else if (error.message === "The value is over 2: " + input) {
            p1.innerHTML = `Your number value is: ${input}`;

            p2.innerHTML = "Your number value is greater than 2: <span style='color: blue'>" + input + "</span>";
            p3.innerHTML = "<span style='color: red'>Your Number is in the correct range</span>";
        } else if (error.message === "Your value is in the correct range") {
            p1.innerHTML = `Your number value is: ${input}`;
            p2.innerHTML = "Your number value is greater than 2: <span style='color: blue'>" + input + "</span>";
            p3.innerHTML = "<span style='color: red'>Your Number is in the correct range</span>";
        }
    }
})
