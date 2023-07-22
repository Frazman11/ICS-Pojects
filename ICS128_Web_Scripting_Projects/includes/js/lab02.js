let p1 = parseInt(prompt("Enter Price for Room 1"));
let p2 = parseInt(prompt("Enter Price for Room 2"));
let p3 = parseInt(prompt("Enter Price for Room 3"));
document.getElementById('3price').innerHTML += '$' + p1 + ', ' + '$' + p2 + ', ' + '$' + p3;
var btn1 = document.getElementById('calc1')
btn1.addEventListener('click', calc);
function calc(){
    let mean = 0;
    let sum = p1 + p2 + p3;
    mean = (sum/3).toFixed(2);
    document.getElementById('mean').innerHTML += '$' + mean;

    let middle = 0;
    if((p1>=p2 && p1 <= p3)|| (p1 <= p2 && p1 >= p3)){
        middle = p1;
    } else if ((p2>=p1 && p2<=p3)||(p2<=p1 && p2>=p3)){
        middle = p2;
    } else if ((p3>=p1 && p3<=p2)||(p3<=p1 && p3>=p2)){
        middle = p3;
    }
    if (middle % 2 == 0){
        document.getElementById('middle').innerHTML += "<span style = 'color: red'>" + '$' + middle + "<span>";
    } else {
        document.getElementById('middle').innerHTML += '$' + middle;
    }
btn1.removeEventListener('click', calc);   
}

var btn2 = document.getElementById('calc2')
btn2.addEventListener('click', calc1);
function calc1() {
    // let num = parseInt(document.getElementById('hotelValue').innerHTML);
    let perc = document.getElementById('percent');
    var num = document.getElementById('hotelValue').value;
    
    // parseInt(prompt("Please enter a number between 1-100"));
    if(num < 1 || num > 100){
        alert("Incorrect - not between 0-100, enter again:");
    }
    // while(num < 1 || num > 100){
    //     num = parseInt(prompt("Incorrect - not between 0-100, enter again:"));
    // }
    // document.getElementById('hotelValue').value = num;
    switch (true) {
        case (num >= 90 && num <= 100):
            perc.innerHTML = "<span style='color: green;'>" + num + "%</span> Booked!";
            break;
        case (num >= 80 && num <= 89):
            perc.innerHTML = "<span style='color: blue;'>" + num + "%</span> Booked!";
            break;
        case (num >= 65 && num <= 79):
            perc.innerHTML = "<span style='color: yellow;'>" + num + "%</span> Booked!";
            break;
        case (num >= 51 && num <= 64):
            perc.innerHTML = "<span style='color: black;'>" + num + "%</span> Booked!";
            break;
        case (num >= 0 && num <= 50):
            perc.innerHTML = "<span style='color: red;'>" + num + "%</span> Booked!";
            break;
        default:
            perc.innerHTML = "Invalid number";
            break;
    }
    // btn2.removeEventListener('click', calc1);
}


let btn3 = document.getElementById('calc3');
btn3.addEventListener('click', iterate);
function iterate(){
    let iteration = parseInt(document.getElementById('it').value);
    let symbol = document.getElementById('it').value;
    document.getElementById('print').style.color = "blue";
    let print = document.getElementById('print');
    print.innerHTML = ' ';

    for(var i = 0; i < iteration; i++){
        for(var n = 0; n <= i; n++){
            print.innerHTML += symbol + ' ';
        }
        print.innerHTML += '<br>';
    }
    for(var i = iteration - 1; i > 0; i--){
        for(var n = 0; n < i; n++){
            print.innerHTML += symbol + ' ';
        }
        print.innerHTML += '<br>';
    }
    btn3.removeEventListener('click', iterate);
}
var btn4 = document.getElementById('calc4');
btn4.addEventListener('click', calc4);
function calc4(){
    let a = document.getElementById('alexa').value
    let b = document.getElementById('siri').value
    let print1 = document.getElementById('print1');
    let print2 = document.getElementById('print2');
    let print3 = document.getElementById('print3');

    if (a > b){
        print1.innerHTML += '<span style="color:red">' + a + '</span>';
        print2.innerHTML += '<span style="color:blue">' + b + '</span>';
        print3.innerHTML = '<span style="color: red">' + "Alexa" + '</span>' + " Arrives First!";

    } else if (b > a) {
        print1.innerHTML += '<span style="color:red">' + a + '</span>';
        print2.innerHTML += '<span style="color:blue">' + a + '</span>';
        print3.innerHTML = '<span style="color: red">' + "Siri" + '</span>' + " Arrives First!";
    } else {
        print1.innerHTML += '<span style="color:red">' + a + '</span>';
        print2.innerHTML += '<span style="color:blue">' + a + '</span>';
        print3.innerHTML = "They are Tied!";
    }
    // btn4.removeEventListener('click', calc4);
}


