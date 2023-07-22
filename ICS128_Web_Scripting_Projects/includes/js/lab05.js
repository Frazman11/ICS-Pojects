let btn = document.querySelector("#submit");;
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

function generateCard() {
    card.innerHTML = `<h5>Profile</h5>
  <div class="card" style="width: 18rem;">
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
let namePattern = /\s/gi;

function checkName() {
    let border = document.querySelector('#first_name');
    let name = document.querySelector('#first_name').value;
    if (namePattern.test(name)) {
        border.classList.add("border-danger");
        uncheck(0)
        document.querySelector('#nameError').innerHTML = "First name is invalid, No Spaces";
    } else {
        border.classList.remove("border-danger");
        document.querySelector('#nameError').innerHTML = "";
        check(0);
        return name;
    }
}

function checkLast() {
    let border = document.querySelector('#last_name');
    let last = document.querySelector('#last_name').value;
    if (namePattern.test(last)) {
        border.classList.add("border-danger");
        uncheck(1)
        document.querySelector('#lastNameError').innerHTML = "Last name is invalid, No Spaces";
    } else {
        border.classList.remove("border-danger");
        document.querySelector('#lastNameError').innerHTML = "";
        check(1);
        return last;
    }
}
let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

function checkEmail() {
    let border = document.querySelector('#email');
    let email = document.getElementById('email').value;
    if (!emailPattern.test(email)) {
        border.classList.add("border-danger");
        uncheck(2)
        document.querySelector('#emailError').innerHTML = "Email is invalid, must be name.name@provider.domain";
    } else {
        border.classList.remove("border-danger");
        document.querySelector('#emailError').innerHTML = "";
        check(2);
        return email;
    }
}
let agePattern = /^(?:\d{1,2}|1[01]\d|120)$/;

function checkAge() {
    let age = parseInt(document.getElementById('age').value);
    if (!agePattern.test(age)) {
        let border = document.querySelector('#age');
        border.classList.add("border-danger");
        uncheck(3)
        document.querySelector('#ageError').innerHTML = "Age is invalid, Must be 0-120";
    } else {
        let border = document.querySelector('#age');
        border.classList.remove("border-danger");
        document.querySelector('#ageError').innerHTML = "";
        check(3);
        return age;
    }
}
let phonePattern = /^(\d{3})[-.\s]?(\d{3})[-.\s]?(\d{4})$/;

function checkPhone() {
    let phone = document.getElementById('phone').value;
    if (!phonePattern.test(phone)) {
        let border = document.querySelector('#phone');
        border.classList.add("border-danger");
        uncheck(5)
        document.querySelector('#phoneError').innerHTML = "Phone number is invalid, 123-456-7890";
    } else {
        let border = document.querySelector('#phone');
        border.classList.remove("border-danger");
        document.querySelector('#phoneError').innerHTML = "";
        check(5);
        return phone;
    }
}
//negative lookahead ^(?!.*[DFIOQU]) to prevent DFIOQU from being allowed anywhere in string
//first letter can be A-Z excluding W, X 
let postPattern = /^(?!.*[DFIOQU])[A-VXY][0-9][A-Z]\s?[0-9][A-Z][0-9]$/;

function checkPost() {
    let post = document.getElementById('postal_code').value.toUpperCase();
    let border = document.querySelector('#postal_code');
    if (!postPattern.test(post)) {
        border.classList.add("border-danger");
        uncheck(4)
        document.querySelector('#postError').innerHTML = "Postal Code is Invalid (Must be ANA NAN)";
    } else {
        border.classList.remove("border-danger");
        document.querySelector('#postError').innerHTML = "";
        check(4);
        return post;
    }
}
//account picture : Photo by <a href="https://unsplash.com/es/@ninjason?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Jason Leung</a> on <a href="https://unsplash.com/photos/1DjbGRDh7-E?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>