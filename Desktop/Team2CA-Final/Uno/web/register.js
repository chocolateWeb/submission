function validateForm()
{
    var emailaddr = document.forms["myform"]["emailaddr"].value;
    var password1 = document.forms["myform"]["password1"].value;
    var password2 = document.forms["myform"]["password2"].value;
        

    if (password1 != password2)
    {
        alert("Both password fields must be the same.");
        return false;
    }
    
    if (! /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailaddr))
    {
        alert("Invalid email address.");
        return false;
    }
    
    return true;
}
