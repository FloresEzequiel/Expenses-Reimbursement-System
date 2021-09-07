const urlParams = new URLSearchParams(window.location.search)
const userId = urlParams.get("id")
let sortE=0
let x


window.onload = async function(){
    const sesR = await fetch(`${domain}/api/check-session`)
    const sesUsDa = await sesR.json();
    //console.log(sesUsDa)

    if(sesUsDa.data){
        if(sesUsDa.data.id !=userId){
            window.location=`${domain}/`
        }
    }else{
        window.location=`${domain}/`
    }
    filldata();
}

async function filldata(){
    const ticketResponse = await fetch(`${domain}/api/employee?id=${userId}`)
    const ticketData = await ticketResponse.json();

    if(sortE==0){
ticketData.data.sort((a,b)=>{
        if(a.status<b.status){
            return -1
        }
       if(a.status>b.status){
          return 1
       }
       return 0;
    })
    }

    if(sortE==9){
        ticketData.data.sort((a,b)=>{
                if(a.status>b.status){
                    return -1
                }
               if(a.status<b.status){
                  return 1
               }
               return 0;
            })
            }


    if(sortE==1){
        ticketData.data.sort((a,b)=>{
            if(a.id<b.id){
                return -1
            }
           if(a.id>b.id){
              return 1
           }
           return 0;
        })
    }
    if(sortE==2){
        ticketData.data.sort((a,b)=>{
            if(a.id>b.id){
                return -1
            }
           if(a.id<b.id){
              return 1
           }
           return 0;
        })
    }

    if(sortE==3){
        ticketData.data.sort((a,b)=>{
            if(a.amount<b.amount){
                return -1
            }
           if(a.amount>b.amount){
              return 1
           }
           return 0;
        })
    }
    if(sortE==4){
        ticketData.data.sort((a,b)=>{
            if(a.amount>b.amount){
                return -1
            }
           if(a.amount<b.amount){
              return 1
           }
           return 0;
        })
    }
    if(sortE==5){
        ticketData.data.sort((a,b)=>{
            if(a.submitted<b.submitted){
                return -1
            }
           if(a.submitted>b.submitted){
              return 1
           }
           return 0;
        })
    }
    
    if(sortE==6){
        ticketData.data.sort((a,b)=>{
            if(a.submitted>b.submitted){
                return -1
            }
           if(a.submitted<b.submitted){
              return 1
           }
           return 0;
        })
    }
    if(sortE==7){
        ticketData.data.sort((a,b)=>{
            if(a.resolved<b.resolved){
                return -1
            }
           if(a.resolved>b.resolved){
              return 1
           }
           return 0;
        })
    }

    if(sortE==8){
        ticketData.data.sort((a,b)=>{
            if(a.resolved>b.resolved){
                return -1
            }
           if(a.resolved<b.resolved){
              return 1
           }
           return 0;
        })
    }

    


    //console.log(ticketData.data)
    let tickerElem= document.getElementById("rtl=container")
    tickerElem.innerHTML=``;

    
    let table = document.createElement('table')
    let thead = document.createElement('thead')
    let tbody = document.createElement('tbody')
    table.appendChild(thead)
    table.appendChild(tbody)
    tickerElem.appendChild(table)
        let row1=document.createElement('tr')
        let heading1=document.createElement('th')
        //heading1.addEventListener.onclick=myfunction()
        heading1.innerHTML="Reimbursement ID"
        heading1.addEventListener;
        heading1.id="IdS"
        let heading2=document.createElement('th')
        heading2.innerHTML="Amount"
        heading2.addEventListener;
        heading2.id="amSort"
        let heading3=document.createElement('th')
        heading3.innerHTML="Submitted Date"
        heading3.addEventListener;
        heading3.id="sBS";
        let heading4 = document.createElement('th')
        heading4.innerHTML="Resolved Date"
        heading4.addEventListener;
        heading4.id="sortRD";
        let heading5=document.createElement('th')
        heading5.innerHTML="Resolver ID"
        let heading6=document.createElement('th')
        heading6.innerHTML="Description"
        let heading7=document.createElement('th')
        heading7.innerHTML="Type"
        let heading8=document.createElement('th')
        heading8.innerHTML="Status"
        heading8.addEventListener;
        heading8.id = "stS";

        row1.appendChild(heading1)
        row1.appendChild(heading2)
        row1.appendChild(heading3)
        row1.appendChild(heading4)
        row1.appendChild(heading5)
        row1.appendChild(heading6)
        row1.appendChild(heading7)
        row1.appendChild(heading8)
        thead.appendChild(row1)
        let x=2

    ticketData.data.forEach(item => {
        var time="row"+x
        
        var time = document.createElement('tr')

        var row_data1=document.createElement('td')
        row_data1.innerHTML=item.id
        var row_data2 =document.createElement('td')
        row_data2.innerHTML=item.amount
        var row_data3= document.createElement('td')
        row_data3.innerHTML=new Date(item.submitted)

        var row_data4= document.createElement('td')

        if(item.resolved==null){
            row_data4.innerText="Not Yet resolved"
        }else{
            row_data4.innerHTML=new Date(item.resolved)
        }

        var row_data5=document.createElement('td')

        if(item.resolver==null||item.resolver==0){
            row_data5.innerHTML="Pending Assignment"
        }else{
            row_data5.innerHTML=item.resolver
        }

        var row_data6=document.createElement('td')
        row_data6.innerHTML=item.description

        var row_data8=document.createElement('td')

        if(item.status==1){
            row_data8.innerHTML="Pending"
            row_data8.style.backgroundColor="yellow"
        }
        if(item.status==2){
            row_data8.innerHTML="Approved"
            row_data8.style.backgroundColor="#A8F387"
        }
        if(item.status==3){
            row_data8.innerHTML="Denied"
            row_data8.style.backgroundColor="#E20A4A"
        }

        var row_data7=document.createElement('td')
        if(item.type==1){
            row_data7.innerHTML="Lodging"
        }
        if(item.type==2){
            row_data7.innerHTML="Travel"
        }
        if(item.type==3){
            row_data7.innerHTML="Food"
        }

        
        time.appendChild(row_data1)
        time.appendChild(row_data2)
        time.appendChild(row_data3)
        time.appendChild(row_data4)
        time.appendChild(row_data5)
        time.appendChild(row_data6)
        time.appendChild(row_data7)
        time.appendChild(row_data8)
        tbody.appendChild(time)
        x=x+1
        
    });
    let reorderId = document.getElementById('IdS')
reorderId.onclick = async function reId(){
    if(sortE==1){
        sortE=2;
        filldata();
    }else{
        sortE=1;
        filldata();
    }
}

let reorderAm = document.getElementById('amSort')
reorderAm.onclick = async function reA(){
    if(sortE==3){
        sortE=4;

        filldata();
    }else{
        sortE=3
       
        filldata();
    }
}

let reorderStatus = document.getElementById('stS')
reorderStatus.onclick = async function reS(){
    if(sortE==9){
        sortE=0;
        filldata();

    }else{
        sortE=9;
        filldata();
    }
}

let reorderSub = document.getElementById('sBS')
reorderSub.onclick = async function reRD(){
    if(sortE==5){

        sortE=6;
        filldata();
    }else{
        sortE=5;
        filldata();
    }
}

let reorderReDa = document.getElementById('sortRD')
reorderReDa.onclick = async function reREDA(){
    if(sortE==7){
        sortE=8;
        filldata();

    }else{
        sortE=7;
        filldata();
    }
}

}

let logOutBtn = document.getElementById("logout-btn")

logOutBtn.onclick= async function(){
    let logOutRes= await fetch (`${domain}/api/logout`)

    let logOutResData = await logOutRes.json();

    if(logOutResData.success){
        window.location=`${domain}/`
    }


}



let createBtn = document.getElementById("create-btn")

createBtn.onclick = async function(){

    window.location = `${domain}/create?id=${userId}`
}


