const urlParams = new URLSearchParams(window.location.search)
const userId = urlParams.get("id")

let createnew = document.getElementById("register-form")

createnew.onsubmit=async function(e){
    e.preventDefault();

    let userN = document.getElementById("username").value;
    let passW = document.getElementById("password").value;
    let firstN = document.getElementById("fname").value;
    let lastN = document.getElementById("lname").value;
    let eM = document.getElementById("email").value;
    let type = document.getElementById("type").value;

    let response = await fetch(`${domain}/api/create`,{
        method: "POST",
        body: JSON.stringify({
            id: null,
            username: userN,
            password: passW,
            firstName: firstN,
            lastName: lastN,
            email: eM,
            rol: type
        })

    })

    let respD = await response.json()

    if(respD.success){
        window.location = `${domain}/menuadmin?id=${userId}`
    }

}