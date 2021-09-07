let logf= document.getElementById("login-form");

window.onload = async function(){
    const sesR = await fetch(`${domain}/api/check-session`)
    const sesUsDa = await sesR.json();

    if(sesUsDa.data){
        if(sesUsDa.data.rol==1){
            window.location = `${domain}/menuadmin?id=${sesUsDa.data.id}`
        }
        if(sesUsDa.data.rol==2){
            window.location = `${domain}/menuemploy?id=${sesUsDa.data.id}`
        }
        
    }
}



logf.onsubmit = async function(e){

    e.preventDefault();

    //get the values necesary from the user

    let username = document.getElementById("username").value;

    let password = document.getElementById("password").value;

   // console.log(username,password)

    //send the value to the backend

    let response = await fetch(`${domain}/api/login`,{
        method:"POST",
        body: JSON.stringify({
            username: username,
            password: password
        })
    })

    let respDa = await response.json();
    //console.log(respDa)

    if(respDa.success){
        console.log(respDa.data.rol)
        if(respDa.data.rol==1){
            window.location = `${domain}/menuadmin?id=${respDa.data.id}`
        }
        if(respDa.data.rol==2){
            window.location = `${domain}/menuemploy?id=${respDa.data.id}`
        }
        
    }else{
        let mess=document.getElementById("login-message")
        mess.style = "background-color: #FE214F;"
        mess.innerText = respDa.message
    }
}
