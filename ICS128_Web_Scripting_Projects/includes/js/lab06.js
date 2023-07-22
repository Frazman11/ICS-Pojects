class Hotel {
    roomtypes;
    swimmingPool = false;
    airportShuttle = false;
    restaurants = [
        ["Donde La Arepa", "Colombian"],
        ["Toka Tonkatsu", "Japanese"],
        ["Pizza Hermosa", "Italian"]
    ];
    roomtypes = ["Double", " Queen", " King", " Luxury"];
    constructor(name, location, rooms, booked, gym) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.booked = booked;
        this.gym = gym;
    }
    //getters and setters
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
//create Hotel and Resort 
let resort = new Resort('Nature Park Getaway', 'Canmore', 10, 8, true,
    'Resort & Spa', true, true, true);
let hotel = new Hotel('Fairmont Hotel', 'Banff', 30, 10, true);
hotel.swimmingPool = true;
hotel.gym = true;

//set html elements
let container1 = document.getElementById('container1');
let container2 = document.getElementById('container2');
let activeCard = hotel;
let sister = document.querySelector('#sister');

//add eventListener for Sister button
sister.addEventListener('click', function() {
    toggleCards();
    //keep track of active card
    activeCard = activeCard === hotel ? resort : hotel;
})
/**
 * Creates the Hotel Card innerHTML based on the created hotel instance
 */
function populateCard() {
    container1.innerHTML += `
  </div>
    <div class="card m-2" style="width: col-md-4;">
    <div class="card-body">
    <h5 class="card-title">${hotel.name}</h5>
    <p class="card-text"><u>Hotel Info</u></p>
    
    <p class="card-text" id="location">The <span style="font-weight: bold;">${hotel.name}</span> located in <span style="font-weight: bold;">${hotel.location}</span></p>
    <p class="card-text" id="roomTypes">The available room types are: ${hotel.roomtypes}</p>
    <p class="card-text" id="shuttle"><span style="font-weight: bold;">Shuttle Service? </span>${hotel.airportShuttle}</p>
    <p class="card-text" id="pool"><span style="font-weight: bold;">Swimming Pool? </span>${hotel.swimmingPool}</p>
    <p class="card-text" id="restaurants"></p>
    <p class="card-text" id="bookedP">There are ${hotel.booked} / ${hotel.rooms} booked.</p>
    <a id="hotel-book" class="btn btn-primary">Book Room</a>
    <a id="hotel-cancel" class="btn btn-danger">Cancel Room</a>
    </div>
    </div>`
    restaurants();
}
/**
 * Creates the resort innerHTML based on the resort instance previously created. Set display to none by default, as hotel is first to display
 */
function populateResort() {
    container2.innerHTML = `
  </div>
    <div class="card m-2" style="width: col-md-4;">
    <div class="card-body">
    <h5 class="card-title">${resort.name}</h5>
    <p class="card-text"><u>Resort Info</u></p>
    <p class="card-text" id="location">The <span style="font-weight: bold;">${resort.name}</span> located in <span style="font-weight: bold;">${resort.location}</span></p>
    <p class="card-text" id="roomTypes"><span style="font-weight: bold;">Is it On the Beach? ${resort.beachFront}</span></p>
    <p class="card-text" id="shuttle">Kid's Club? ${resort.kidsClub}</p>
    <p class="card-text" id="pool"><span style="font-weight: bold;">Does it have a bar? ${resort.bar}</span></p>
    <p class="card-text" id="bookedPResort">There are ${resort.booked} / ${resort.rooms} booked.</p>
    <a id="resort-book" class="btn btn-primary">Book Room</a>
    <a id="resort-cancel" class="btn btn-danger">Cancel Room</a>
    </div>
    </div>`
    container2.style.display = "none";
}
/**
 * Toggles which card is displayed
 */
function toggleCards() {
    container1.style.display = container1.style.display === "none" ? "block" :
        "none";
    container2.style.display = container2.style.display === "none" ? "block" :
        "none";
}
/**
 * Populates the restaurant details area on the hotel card
 */
function restaurants() {
    let counter = 1;
    let restaurantP = document.getElementById('restaurants');
    for (let [key, value] of hotel.restaurants) {
        restaurantP.innerHTML +=
            `<br><span style="font-weight: bold;">${counter}. ${key}</span> / Type / <span style="font-weight: bold;">${value}</span><br>`
        counter++;
    }
}
/**
 * Startup function which triggers both cards to be populated. Sets html elements for all buttons, and adds event listeners for all buttons. Book and Cancel functions are passed either hotel/resort and hotelParagraph/resortParagraph as arguments, to update the relative fields. Wanted to find a cleaner way to do this...
 */
function startup() {
    populateCard();
    populateResort();
    let hotelBookBtn = document.getElementById('hotel-book');
    let hotelCancelBtn = document.getElementById('hotel-cancel');
    let resortBookBtn = document.getElementById('resort-book');
    let resortCancelBtn = document.getElementById('resort-cancel');
    let hotelBookedP = document.getElementById('bookedP');
    let resortBookedP = document.getElementById('bookedPResort');
    hotelBookBtn.addEventListener('click', function() {
        bookRoom(hotel, hotelBookedP);
    });
    hotelCancelBtn.addEventListener('click', function() {
        cancelRoom(hotel, hotelBookedP);
    });
    resortBookBtn.addEventListener('click', function() {
        bookRoom(resort, resortBookedP);
    });
    resortCancelBtn.addEventListener('click', function() {
        cancelRoom(resort, resortBookedP);
    });
}
startup();
//Button functionality
let bookedP = document.getElementById('bookedP');
let bookedPResort = document.getElementById('bookedPResort');
let bookBtn = document.getElementById('book');
let cancelBtn = document.getElementById('cancel');
/**
 * Controls the behaviour of the booking function. Updates the card details, and color depending on occupancy level. 
 * @param {1} activeCard 
 * @param {2} bookedParagraph 
 */
function bookRoom(activeCard, bookedParagraph) {
    if (activeCard.booked < activeCard.rooms) {
        activeCard.booked += 1;
        alert(
            `Thank you for booking! There are ${activeCard.rooms - activeCard.booked} rooms remaining.`)
        bookedParagraph.innerText =
            `There are ${activeCard.booked} / ${activeCard.rooms} booked.`;
        if ((activeCard.booked / activeCard.rooms) > 0.8) {
            bookedParagraph.classList.add("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.remove("text-success");
        } else if ((activeCard.booked / activeCard.rooms) > 0.65) {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.add("text-warning");
            bookedParagraph.classList.remove("text-success");
        } else if ((activeCard.booked / activeCard.rooms) > 0.5) {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.add("text-success");
        } else {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.add("text-success");
        }
    } else {
        alert("The Hotel is full. Your reservation was denied.");
    }
}
/**
 * Controls the behaviour of the cancel function. Updates the card details, and color depending on occupancy level. 
 * @param {1} activeCard 
 * @param {2} bookedParagraph 
 */
function cancelRoom(activeCard, bookedParagraph) {
    if (activeCard.booked >= 1) {
        activeCard.booked -= 1;
        alert(
            `We're sorry you had to cancel. There are ${activeCard.rooms - activeCard.booked} rooms remaining.`)
        bookedParagraph.innerText =
            `There are ${activeCard.booked} / ${activeCard.rooms} booked.`;
        if ((activeCard.booked / activeCard.rooms) > 0.8) {
            bookedParagraph.classList.add("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.remove("text-success");
        } else if ((activeCard.booked / activeCard.rooms) > 0.65) {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.add("text-warning");
            bookedParagraph.classList.remove("text-success");
        } else if ((activeCard.booked / activeCard.rooms) > 0.5) {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.add("text-success");
        } else {
            bookedParagraph.classList.remove("text-danger");
            bookedParagraph.classList.remove("text-warning");
            bookedParagraph.classList.add("text-success");
        }
    } else {
        alert("You do not have a reservation to cancel.");
    }
}