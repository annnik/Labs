var request = null;
function createGetCustomers() 
{
    try {
        request = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            request = new ActiveXObject("MsXML2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }

    if (request == null)
        alert("Error creating request object!");
}

function getUsers()
{
    createGetUsers()
    var url = "/webapps/get_customers";
    request.onreadystatechange = handleGetCustomers;
    request.open("POST", url, true);
    request.send(null);
}

function handleGetUsers() {
    if (request.readyState==4 && request.status==200)
    { 
        var table = document.getElementById("customers_table");
        table.innerHTML=""
         var row =  table.insertRow(i + 1);
            var cell = row.insertCell(0);
            cell.innerHTML="Index"
            var cell = row.insertCell(1);
            cell.innerHTML="Name"
            var cell = row.insertCell(2);
            cell.innerHTML=""
        var det=eval("("+request.responseText+")");
        for(var i=0; i<det.length; i++) {
            var row =  table.insertRow(i + 1);
            var cell = row.insertCell(0);
            cell.innerHTML="<a href=\"./customers_details.html?id=" + det[i].login + "\">"+ i +"</a>"
            var cell = row.insertCell(1);
            cell.innerHTML=det[i].name
            var cell = row.insertCell(2);
            cell.innerHTML="<button onclick=\"removeCustomer('" + det[i].login +"')\"\>Remove\</button\>"
        }
    }
}