function validateRegister()
{
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if(name=="")
    {
        alert("Name Cannot be Empty");
        return false;
    }

    if(email == "")
    {
        alert("Email cannot be Empty");
        return false;
    }

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    if(!email.match(emailPattern))
    {
        alert("Enter Valid Email");
        return false;
    }

    if(password == "")
    {
        alert("Password cannot be empty");
        return false;
    }

    if(password.length < 6)
    {
        alert("Password must be  atleast 6 characters");
        return false;
    }
    return true;
}

function validateLogin()
{
    let email = document.getElementById("loginEmail").value;
    let password = document.getElementById("loginPassword").value;

    if(email == "")
    {
        alert("Email Required");
        return false;
    }

    if(password == "")
    {
        alert("Passwowrd Required");
        return false;
    }
    return true;
}