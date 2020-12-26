
const nav1 = document.querySelector(".nav1");
const nav2 = document.querySelector(".nav2");
const nav3 = document.querySelector(".nav3");
const nav4 = document.querySelector(".nav4");
const main1 = document.querySelector(".main1");
const main2 = document.querySelector(".main2");
const main3 = document.querySelector(".main3");
const main4 = document.querySelector(".main4");
const logOut = document.querySelector(".log-out");

nav1.addEventListener("click", ()=> {
    removeActive();
    addHide();
    nav1.classList.add("active");
    main1.classList.remove("hide");
})
nav2.addEventListener("click", ()=> {
    removeActive();
    addHide();
    nav2.classList.add("active");
    main2.classList.remove("hide");
})

nav3.addEventListener("click", ()=> {
    removeActive();
    addHide();
    nav3.classList.add("active");
    main3.classList.remove("hide");
})
nav4.addEventListener("click", ()=> {
    removeActive();
    addHide();
    nav4.classList.add("active");
    main4.classList.remove("hide");
    
})
logOut.addEventListener("click", ()=>{
    window.location.href = "http://localhost:8080/logout"
})

const removeActive = () => {
    nav1.classList.remove("active");
    nav2.classList.remove("active");
    nav3.classList.remove("active");
    nav4.classList.remove("active");

}
const addHide = () => {

    main1.classList.contains("hide") ? "" : main1.classList.add("hide");
    main2.classList.contains("hide") ? "" : main2.classList.add("hide");
    main3.classList.contains("hide") ? "" : main3.classList.add("hide");
    main4.classList.contains("hide") ? "" : main4.classList.add("hide");
}


const getProfile = async () => {
    const profile = await fetch('/profile');
    res = await profile.json();
    
    const title = document.getElementById("title");
    const fname = document.getElementById("fname");
    const lname = document.getElementById("lname");
    const phone = document.getElementById("phone");
    const email = document.getElementById("email");
    const username = document.getElementById("username");

    title.textContent = `${res.firstName}'s Profile`;
    fname.textContent = `${res.firstName}`;
    lname.textContent = `${res.lastName}`;
    phone.textContent = `${res.phone}`;
    email.textContent = `${res.email}`;
    username.textContent = `${res.username}`;

    console.log(res)
    
}

const getReimbByID = async () => {
    const reimb = await fetch('/pendingId');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("pending-id");
    
    const tbody = document.createElement("tbody");
    table.appendChild(tbody);

    tbody.innerHTML = "";

    for(i=0; i<res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<td>${res[i].amount}</td><td>${res[i].reason}</td>`
    }
}

const getReimbPending = async () => {
    const reimb = await fetch('/pending');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("pending");
    
    const tbody = document.createElement("tbody");
    table.appendChild(tbody);
    for(i=0; i< res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<tr><td>${res[i][0].firstName} ${res[i][0].lastName}</td><td>${res[i][1].amount}</td><td>${res[i][1].reason}</td><button class="btn btn-success btn-reimb" id="${res[i][1].id}" onclick='approve(this)'><i class="fas fa-check"></i></button><button class="btn btn-danger btn-reimb" id="${res[i][1].id}" onclick='deny(this)'>X</button></tr>` 
    }
}

const approve = (e) => {
    console.log(e.id);
    const id = e.id;
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
           console.log("Sending...")
        }
    };
    xhttp.open("POST", 'approve', true);
    xhttp.send(id);
    window.location.reload();
}

const deny = (e) => {
    console.log(e);
    const id = e.id;
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
           console.log("Sending...")
        }
    };
    xhttp.open("POST", 'deny', true);
    xhttp.send(id);
    window.location.reload();
}


const getResolved = async () => {
    const reimb = await fetch('/resolved');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("resolved");
    
    const tbody = document.createElement("tbody");
    tbody.innerHTML = "";
    table.appendChild(tbody);
    for(i=0; i< res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<tr><td>${res[i][0].firstName} ${res[i][0].lastName}</td><td>${res[i][1].amount}</td><td>${res[i][1].reason}</td><td>${res[i][1].result}</td></tr>` 
    }
}


const getEmployees = async () => {
    const reimb = await fetch('/getemployees');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("employees");
    
    const tbody = document.createElement("tbody");
    table.appendChild(tbody);
    tbody.innerHTML = "";
    for(i=0; i< res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<tr><td>${res[i].firstName} ${res[i].lastName}</td><td>${res[i].phone}</td><td>${res[i].username}</td></tr>` 
    }
}

const getResolvedByID = async () => {
    const reimb = await fetch('/resolvedid');
    res = await reimb.json();
    console.log(res);
    const table = document.getElementById("resolved-id");
    
    const tbody = document.createElement("tbody");
    table.appendChild(tbody);
    for(i=0; i< res.length; i++){
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.innerHTML = `<tr><td>${res[i][1].amount}</td><td>${res[i][1].reason}</td><td>${res[i][1].result}</td></tr>` 
    }
}
if(window.location.pathname == "/employee"){
    getResolvedByID();
    getReimbByID();
    getProfile();
    
} else{
    getReimbPending();
    getEmployees();
    getResolved();
    getProfile();

}
