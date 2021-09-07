const urlParams = new URLSearchParams(window.location.search)
const userId = urlParams.get("id")

let regf= document.getElementById("register-form");
regf.onsubmit = async function(e){

    e.preventDefault();
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
   // let receipt = document.getElementById("receipt").files[0].name;
    let receipt = "";
    let author = userId;
    let status=1;
    let type = document.getElementById("type").value;

//$('#ItemPreview').attr('src', `data:image/png;base64,${}`);
    let response = await fetch(`${domain}/api/employee?id=${userId}`,{
        method: "POST",
        body: JSON.stringify({
            amount: amount,
            description: description,
            receipt: receipt,
            author: author,
            status: status,
            type:type
        })

    })

    let respD= await response.json()
   // console.log(response)
   // console.log(amount)
   // console.log(description)
   // console.log(receipt)
   // console.log(author)
  //  console.log(status)
   // console.log(type)
   if(respD.success){
       window.location = `${domain}/menuemploy?id=${userId}`
   }

}