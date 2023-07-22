// Menu Functionality
$('#menubtn').on('click', openMenu);
$('#closebtn').on('click', closeMenu);

function openMenu() {
    // console.log("openMenu activated")
    $('#sideMenu').css("width", "250px");
    $('#main').css("marginLeft", "250px");
    //    $('body').css("backgroundColor", "rgba(0,0,0,0.4)")
}

function closeMenu() {
    $('#sideMenu').css("width", "0px");
    $('#main').css("marginLeft", "0px");
    // $('body').css("backgroundColor", "rgba(0,0,0,0.4)")
}
//  Login Details Checking
let btn = document.querySelector("#submit");
btn.addEventListener('click', checkForm);
let person = {
    name: '',
    lastName: '',
    email: '',
    age: 0,
    phone: '',
    post: '',
};

function checkForm() {
    person.name = checkName();
    person.lastName = checkLast();
    person.email = checkEmail();
    person.age = checkAge();
    person.phone = checkPhone();
    person.post = checkPost();
    //check if all attributes have been correctly assigned, then all regex tests will have passed and we can generate the card
    if (person.name && person.lastName && person.email && person.age && person.phone && person.post) {
        generateCard();
        logoutBtn.style.display = "block";
        loginBtn.style.display = "none";
    }
}
let logoutBtn = document.querySelector("#logout");
let loginBtn = document.querySelector("#login");
let account = document.getElementById('accountName');
logoutBtn.addEventListener('click', logout);

function logout() {
    card.innerHTML = '';
    logoutBtn.style.display = "none";
    loginBtn.style.display = "block";
    account.innerHTML = '';
    uncheck(0);
    uncheck(1);
    uncheck(2);
    uncheck(3);
    uncheck(4);
    uncheck(5);
}
// Create Account Card
function generateCard() {
    card.innerHTML = `<h5>Profile</h5>
  <div class="card" style="width: 100%;">
  <img src="./includes/assets/lab05 pictures/walle.jpg" class="card-img-top" alt="...">
  <div class="card-body">
  <h5 class="card-title">${person.name} ${person.lastName}</h5>
  <p class="card-text"><strong>Email:</strong> ${person.email}<br>
  </p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">      <strong>Age: </strong> <span style="color: red;">${person.age}</span><br>
    </li>
    <li class="list-group-item">      <strong>Postal Code: </strong><span style="color: blue;">${person.post}</span></li>
    <li class="list-group-item">      <strong>Phone: </strong><span style="color: green;">${person.phone}</span><br>
    </li>
  </ul>
</div>
  `
    // loginBtn.style.display = "none";
    // logoutBtn.style.display = "";
    document.getElementById('accountName').innerHTML = `Hello, ${person.name} ${person.lastName} `;
    setTimeout(closefunction, 550);
}

function closefunction() {
    document.getElementById('close').click();
}
//use QuerySelectorAll to get all of the elements with this class name, then iterate through 
//their id's from idList and add/remove display classes.
function check(num) {
    let checkMarks = document.querySelectorAll('.checkMark');
    let checkMark = checkMarks[num];
    if (checkMark) {
        checkMark.classList.remove("d-none");
        checkMark.classList.add("d-block");
    }
}

function uncheck(num) {
    let checkMarks = document.querySelectorAll('.checkMark');
    let checkMark = checkMarks[num];
    if (checkMark) {
        checkMark.classList.remove("d-block");
        checkMark.classList.add("d-none");
    }
}
// Regex
let namePattern = /^[A-Za-z]+$/;
let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
let agePattern = /^(?:\d{1,2}|1[01]\d|120)$/;
let phonePattern = /^(\d{3})[-.\s]?(\d{3})[-.\s]?(\d{4})$/;
let postPattern = /^[ABCEGHJ-NPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ -]?\d[ABCEGHJ-NPRSTV-Z]\d$/i;

function checkValue(id, pattern, errorID, errorMessage) {
    let input = document.getElementById(id);
    let value = input.value;
    if (!pattern.test(value)) {
        input.classList.add("border-danger");
        uncheck(id)
        document.getElementById(errorID).innerHTML = errorMessage;
    } else {
        input.classList.remove("border-danger");
        document.getElementById(errorID).innerHTML = "";
        check(id);
        return value;
    }
}

function checkName() {
    return checkValue('first_name', namePattern, 'nameError', 'First name is invalid, No Spaces')
}

function checkLast() {
    return checkValue('last_name', namePattern, 'lastNameError', 'Last name is invalid, No Spaces');
}

function checkEmail() {
    return checkValue('email', emailPattern, 'emailError', 'Email is invalid, must be name.name@provider.domain');
}

function checkAge() {
    let age = parseInt(document.getElementById('age').value);
    return checkValue('age', agePattern, 'ageError', 'Age is invalid, Must be 0-120');
}

function checkPhone() {
    return checkValue('phone', phonePattern, 'phoneError', 'Phone number is invalid, 123-456-7890');
}

function checkPost() {
    return checkValue('postal_code', postPattern, 'postError', 'Postal Code is Invalid (Must be ANA NAN)');
}



  // function to scroll to the #container
  function scrollToContainer() {
    console.log("Scroll")
    const container = document.getElementById('left2');
    container.scrollIntoView({ behavior: 'smooth' });
  }


// //account picture : Photo by <a href="https://unsplash.com/es/@ninjason?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Jason Leung</a> on <a href="https://unsplash.com/photos/1DjbGRDh7-E?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//HOTEL DETAILS//
class Hotel {
    roomtypes;
    booked = 0;
    swimmingPool = false;
    airportShuttle = false;
    restaurants = [
        ["Curry 36", "German"],
        ["Mustafas Gemüse Kebap", "Turkish"],
        ["Ristorante A Mano", "Italian"],
        ["Zur Letzten Instanz", "German"],
        ["Vapiano", "Italian"],
        ["Renger-Patzsch", "German"]
    ];
    roomtypes = ["Standard", " Double", " Deluxe"];
    constructor(name, location, rooms, booked, gym) {
        this._name = name;
        this._location = location;
        this._rooms = rooms;
        this._booked = booked;
        this._gym = gym;
    }
    set name(value) {
        this._name = value;
    }
    get name() {
        return this._name;
    }
    set location(value) {
        this._location = value;
    }
    get location() {
        return this._location;
    }
    set rooms(value) {
        this._rooms = value;
    }
    get rooms() {
        return this._rooms;
    }
    set booked(value) {
        this._booked = value;
    }
    get booked() {
        return this._booked;
    }
    set gym(value) {
        this._gym = value;
    }
    get gym() {
        return this._gym;
    }
}
class Resort extends Hotel {
    resortType;
    beachFront = false;
    kidsClub = true;
    set resortType(value) {
        this._resortType = value;
    }
    set beachFront(value) {
        this._beachFront = value;
    }
    set kidsClub(value) {
        this._kidsClub = value;
    }
    get resortType() {
        return this._resortType;
    }
    get beachFront() {
        return this._beachFront;
    }
    get kidsClub() {
        return this._kidsClub;
    }
    set bar(value) {
        this._bar = value;
    }
    get bar() {
        return this._bar;
    }
    constructor(name, location, rooms, booked, gym, resortType, beachFront,
        kidsClub, bar) {
        super(name, location, rooms, booked, gym);
        this.resortType = resortType;
        this.beachFront = beachFront;
        this.kidsClub = kidsClub;
        this.bar = bar;
    }
}
let resort = new Resort('Berlin Canal Spa', 'Berlin', 10, 8, true,
    'Resort & Spa', true, true, true);
let hotel = new Hotel('East Side Gallery Central Hotel', 'Berlin', 30, 10, true);
hotel.swimmingPool = true;
hotel.gym = true;
// Generate Hotel Info Card
function populateCard() {
    container1.innerHTML += `
</div>
    <div #hotelContainer>
    
    <h5 class="card-title">${hotel.name}</h5>
    <p ><u>Hotel Info</u></p>
    
    <p id="location">The <span style="font-weight: bold;">${hotel.name}</span> located in <span style="font-weight: bold;">${hotel.location}</span></p>
    <p id="roomTypes">The available room types are: ${hotel.roomtypes}</p>
    <p id="shuttle"><span style="font-weight: bold;">Shuttle Service? </span>${hotel.airportShuttle}</p>
    <p id="pool"><span style="font-weight: bold;">Swimming Pool? </span>${hotel.swimmingPool}</p>
    <p id="restaurants1"></p>
    
    </div>`;
    restaurants();
}

function populateResort() {
    container2.innerHTML = `
    </div>
    <div #resortContainer>
    <h5 class="card-title">${resort.name}</h5>
    <p ><u>Resort Info</u></p>
    <p  id="location">The <span style="font-weight: bold;">${resort.name}</span> located in <span style="font-weight: bold;">${resort.location}</span></p>
    <p  id="roomTypes"><span style="font-weight: bold;">Is it On the Beach? ${resort.beachFront}</span></p>
    <p  id="shuttle">Kid's Club? ${resort.kidsClub}</p>
    <p  id="pool"><span style="font-weight: bold;">Does it have a bar? ${resort.bar}</span></p>
    <p id="restaurants2"></p>
    
    </div>`;
    container2.style.display = "none";
    restaurants();
}
let globalHotelCounter = 0;

function toggleCards() {
    container1.style.display = container1.style.display === "none" ? "block" :
        "none";
    container2.style.display = container2.style.display === "none" ? "block" :
        "none";
    globalHotelCounter++;
}
// Add restaurants to info card
function restaurants() {
    let counter = 1;
    let restaurantsHtml1 = '';
    let restaurantsHtml2 = '';
    for (let [key, value] of resort.restaurants) {
        if (counter <= 3) {
            restaurantsHtml1 += `<p id="cc">${counter}</span>. ${key}: ${value}</p>`;
        } else {
            restaurantsHtml2 += `<p id="cc">${counter-3}. ${key}: ${value}</p>`;
        }
        counter++;
    }
    $('#restaurants1').html(restaurantsHtml1);
    $('#restaurants2').html(restaurantsHtml2);
}
// Booking Modal show
function modal() {
    $('#modal').modal('show');
}
let hotelBookedP = document.getElementById('bookedP');
let resortBookedP = document.getElementById('bookedPResort');

function startup() {
    populateCard();
    populateResort();
    let hotelBookBtn = document.getElementById('book');
    let hotelCancelBtn = document.getElementById('cancel');
    let resortBookBtn = document.getElementById('book');
    let resortCancelBtn = document.getElementById('cancel');
    $(document).ready(function() {
        $(".modalClose").click(function() {
            $(".modal").modal('hide');
        });
    });
    hotelCancelBtn.addEventListener('click', function() {
        if (globalHotelCounter % 2 == 0) {
            cancelRoom(hotel, hotelBookedP);
        } else {
            cancelRoom(resort, resortBookedP);
        }
    });
}
let container1 = document.getElementById('container1');
let container2 = document.getElementById('container2');
let activeCard = hotel;
let sister = document.querySelector('#sister');
sister.addEventListener('click', function() {
    toggleCards();
    activeCard = activeCard === hotel ? resort : hotel;
});
startup();
// DOM elements
const bookedP = document.getElementById('bookedP');
const bookedPResort = document.getElementById('bookedPResort');
const bookBtn = document.getElementById('book');
const cancelBtn = document.getElementById('cancel');
// Function to update the booking status paragraph
function updateBookedParagraph(activeCard) {
    //set bParagraph to either bookedP or bPresort depending whether active card is hotel
    const bookedParagraph = activeCard === hotel ? bookedP : bookedPResort;
    bookedParagraph.innerText = `There are ${activeCard.booked} / ${activeCard.rooms} booked.`;
    const bookedRatio = activeCard.booked / activeCard.rooms;
    //toggle text classes depending on bookedRatio
    bookedParagraph.classList.toggle('text-danger', bookedRatio > 0.8);
    bookedParagraph.classList.toggle('text-warning', bookedRatio > 0.65 && bookedRatio <= 0.8);
    bookedParagraph.classList.toggle('text-success', bookedRatio <= 0.65);
}
// Function to book a room
function bookRoom(activeCard) {
    if (activeCard.booked < activeCard.rooms) {
        activeCard.booked += 1;
        updateBookedParagraph(activeCard);
    } else {
        alert('The Hotel is full. Your reservation was denied.');
    }
}
// Function to cancel a room reservation
function cancelRoom(activeCard) {
    if (activeCard.booked >= 1) {
        activeCard.booked -= 1;
        updateBookedParagraph(activeCard);
        alert(`We're sorry you had to cancel. There are ${activeCard.rooms - activeCard.booked} rooms remaining.`);
    } else {
        alert('You do not have a reservation to cancel.');
    }
}
// Handle radio button change event
$(document).ready(function() {
    $("input[name='room']").change(function() {
        $(".roombtn").removeClass("active");
        $(this).closest(".roombtn").addClass("active");
    });
});
// Handle click event on sibling buttons
$(document).ready(function() {
    $('.sisbtn').click(function() {
        $(this).toggleClass('active');
        //when clicked add active to clicked and remove active class from other siblings
    });
});
// Booking widget
$(document).ready(function() {
    $("#datepicker").datepicker({
        showButtonPanel: true
    });
    $("#datepicker2").datepicker({
        showButtonPanel: true
    });
    let selectedRoom = '';
    let price = 0;
    let totalPrice = 0;
    $("#book").click(function() {
        // Check date inputs and selected room
        const date1 = new Date($("#datepicker").val());
        const date2 = new Date($("#datepicker2").val());
        if ($("#datepicker").val() === "") {
            alert("Please select an Arrival Date.");
        } else if (date1.getTime() >= date2.getTime()) {
            alert("Arrival must be before the Departure Date.");
        } else if ($("#datepicker2").val() === "") {
            alert("Please select a Departure Date.");
        } else if (!$("input[name='room']").is(":checked")) {
            alert("Please select a room type.");
        } else {
            const durationDays = (date2.getTime() - date1.getTime()) / 86400000;
            const selectedRadio = document.querySelector('input[name="room"]:checked');
            selectedRoom = selectedRadio ? selectedRadio.id : null;
            switch (selectedRoom) {
                case 'room1':
                    price = 129;
                    break;
                case 'room2':
                    price = 179;
                    break;
                case 'room3':
                    price = 279;
                    break;
                case 'room4':
                    price = 459;
                    break;
                default:
                    price = 0;
            }
            totalPrice = (price * durationDays).toFixed(2);
            $('#results').html(`<p>Your length of stay is ${durationDays} days</p>
                          <p>${price} $/night</p>
                          <p>Total Price: ${totalPrice} $</p>`);
            // Assuming globalHotelCounter is defined somewhere
            if (globalHotelCounter % 2 === 0) {
                bookRoom(hotel);
                $('#bookedP').css("display", "block");
                $('#bookedPResort').css("display", "none");
                modal();
            } else {
                bookRoom(resort);
                $('#bookedP').css("display", "none");
                $('#bookedPResort').css("display", "block");
                modal();
            }
        }
    });
});
// Handle radio button change event
$("input[name='room']").change(function() {
    $(".btn-group label").removeClass("active");
    $(this).closest("label").addClass("active");
});
//Section 3//
let options1 = ["Patio Access"]
let options2 = ["OLED TV", "Walk In Shower"]
let options3 = ["Jacuzzi Tub ", "Complimentary Bar ", "Premium Lighting "]
let rooms = [{
        img: './includes/assets/lab09 pictures/img1.jpg',
        type: "Standard",
        desc: "Single room with a Queen bed",
        price: "$159"
    },
    {
        img: "./includes/assets/lab09 pictures/img2.jpg",
        type: "Double",
        desc: "Double room with 2 Queen beds",
        price: "$219",
        options: options1
    },
    {
        img: "./includes/assets/lab09 pictures/img3.jpg",
        type: "King",
        desc: "Spacious room with King bed",
        price: "$289",
        options: options2
    },
    {
        img: "./includes/assets/lab09 pictures/img4.jpg",
        type: "Penthouse",
        desc: "Spacious room with 2 King beds",
        price: "$469",
        options: options3
    },
]
//img1 source: Photo by <a href="https://unsplash.com/es/@3dottawa?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Point3D Commercial Imaging Ltd.</a> on <a href="https://unsplash.com/photos/oxeCZrodz78?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img2 source: Photo by <a href="https://unsplash.com/@frugalflyer?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Frugal Flyer</a> on <a href="https://unsplash.com/photos/mo3FN80PATM?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img3 source: Photo by <a href="https://unsplash.com/@edelleb?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Edelle Bruton</a> on <a href="https://unsplash.com/photos/PJNO2sLlbB8?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img4 source: Photo by <a href="https://unsplash.com/@mostafasafadel?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Mostafa Safadel</a> on <a href="https://unsplash.com/photos/cHjAxnJk_wQ?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
let container = document.getElementById('container3');
// Generate hotel room cards
for (let i = 0; i < 4; i++) {
    container.innerHTML +=
        `
      
      
<div class="container-fluid" id="card${i} cardCont">
      <div class="card mb-2 p-0" onclick="showSelectedImage(${i})">
        <div class="row no-gutters">
          <div class="col-md-6">
            <img id="img${i}" src="${rooms[i].img}" class="card-img h-100" alt="room previews">
          </div>
          <div class="col-md-6">
            <div class="card-body p-0 fs-6">
              <h3>${rooms[i].type}</h2>
              <p>${rooms[i].desc}</p>
              <p>${rooms[i].price}</p>
              ${optionsDisplay(rooms[i].options)} 
            </div>
          </div>
        </div>
      </div>
  </div>
    
      `;
}
// Change display image with card clicks
function showSelectedImage(cardIndex) {
  // dynamically fetch element id
    let img = document.getElementById(`img${cardIndex}`);
    let target = document.getElementById('showImage');
    // change image src
    target.src = img.src;
}

function optionsDisplay(options) {
    let optionsHTML = '';
    if (options) {
        for (let j = 0; j < options.length; j++) {
            optionsHTML += `<p>${options[j]}</p>`;
        }
    }
    return optionsHTML;
}
// Photo by <a href="https://unsplash.com/ja/@vradenburg?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Adam Vradenburg</a> on <a href="https://unsplash.com/photos/g8DI2ZZFt8I?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//WEATHER API//
let url = 'https://api.openweathermap.org/data/2.5/weather?lat=52.520008&lon=13.404954&appid=bac6ad2877376b1be7598ba4237b6484';
fetch(url)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        $('#temp').prepend((data.main.temp - 273.15).toFixed(1));
        $('#precip').append(data.weather[0].main)
        document.querySelector('#weatherImg').src = `https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;
    });