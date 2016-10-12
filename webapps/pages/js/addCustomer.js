/**
 * 
 */


var request = null;
function createRegRequest() 
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

function addCustomer()
{
    createRegRequest()

    var name = document.getElementById("name").value;
   
    var url = "/webapps/add?"
    + "name=" + name + "&";

    console.log(url);

    request.onreadystatechange = handleRegResponse;
    request.open("POST", url, true);
    request.send(null);
}

function handleRegResponse() {
    if (request.readyState==4)
    { 
        if (request.status==200) {
            alert("Customer created!")
            window.history.back();
        } else {
            alert("Failed to create customer")
        }        
    }
}