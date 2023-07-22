

let options = ["Jacuzzi Tub ", "Complimentary Bar ", "Premium Lighting "]

let rooms = [
    {img: './includes/assets/lab04 pictures/img1.jpg', type: "Standard", desc: "Single room with a Queen bed", price: "$159"},
    {img: "./includes/assets/lab04 pictures/img2.jpg", type: "Double", desc: "Double room with 2 Queen beds", price: "$219"},
    {img: "./includes/assets/lab04 pictures/img3.jpg", type: "King", desc: "Spacious room with a Kind bed and added amenities", price: "$289"},
    {img: "./includes/assets/lab04 pictures/img4.jpg", type: "Penthouse", desc: "Spacious room with panoramic views and 2 King beds", price: "$469", options},
]

//img1 source: Photo by <a href="https://unsplash.com/es/@3dottawa?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Point3D Commercial Imaging Ltd.</a> on <a href="https://unsplash.com/photos/oxeCZrodz78?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img2 source: Photo by <a href="https://unsplash.com/@frugalflyer?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Frugal Flyer</a> on <a href="https://unsplash.com/photos/mo3FN80PATM?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img3 source: Photo by <a href="https://unsplash.com/@edelleb?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Edelle Bruton</a> on <a href="https://unsplash.com/photos/PJNO2sLlbB8?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//img4 source: Photo by <a href="https://unsplash.com/@mostafasafadel?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Mostafa Safadel</a> on <a href="https://unsplash.com/photos/cHjAxnJk_wQ?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
  

let container = document.getElementById('container');

for (let i = 0; i < 4; i++){
    container.innerHTML += 
   `<div class="card mb-3">
   <div class="row no-gutters">
     <div class="col-md-4">
       <img src="${rooms[i].img}" class="card-img" alt="...">
     </div>
     <div class="col-md-8">
       <div class="card-body d-flex flex-column h-100">
         <div>
           <h2 class="card-title">${rooms[i].type}</h2>
           <p>${rooms[i].desc}</p>
           <p>${rooms[i].price}</p>
           ${optionsDisplay(rooms[i].options)}  
         </div>
         <div class="mt-auto align-self-end">
           <button id=btn${i} class="btn btn-primary">Reserve Room ${i+1}</button>
         </div>
       </div>
     </div>
   </div>
 </div>
 `

}
//make a function to return a new html paragraph for each option
function optionsDisplay(options){
    optionsHTML = '';
    if (options){
        for(let j = 0; j < options.length; j++){
            optionsHTML+= `<p> ${options[j]}</p>`;
        }
    }
    return optionsHTML;
}
//make a function to access dynamic button IDs
for(let n = 0; n < 4; n++){
    let btn = document.getElementById(`btn${n}`);
    btn.addEventListener('click', function(){
        reserve(n)
    })
}

//make a function to display an alert when reserve buttons are clicked
function reserve(indexNumber){
    alert(`Room ${indexNumber+1} reserved - cost: ${rooms[indexNumber].price}`);
}


//DOM
let table = document.querySelector('#table'); //.firstChild;
let rowBtn = document.querySelector('#rowBtn');
let clickCount = 2;
rowBtn.addEventListener('click', function(){
    let newRow = document.createElement('tr');  //create element with the specified tag 'tr' --> <tr>
    
    newRow.innerHTML =
        `<tr>
            <td>Row${clickCount} cell1</td>
            <td>Row${clickCount} cell2</td>
        </tr>`;
        
    newRow.classList.add("myClass");    //set custom class for css to target
    table.appendChild(newRow);
    clickCount++;
})
 //since Dom tree is created from HTML, then Styles applies, then script run,
                                        // new elements do not recieve the stlying, must add class manually
     

