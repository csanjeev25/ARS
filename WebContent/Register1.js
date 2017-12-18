function validate()
{
 if( document.abc.title.value == "-1" )
   {
     alert( "Please select an appropriate title!" );
   }
   if( document.abc.country.value == "-1" )
   {
     alert( "Please mention your country!" );
   }
   if( document.abc.password.value!=document.abc.conpassword.value)
   {
	alert( "Please Check Your Password" );
   }
   var fname=document.abc.fname.value;  
   var lname=document.abc.lname.value;  
   var lname=document.abc.uname.value;  
   var password=document.abc.password.value;  
   if (fname==null || fname=="")
   {  
   alert("First Name can't be blank");  
   return false;  
   }
   else if(lname==null || lname=="")
   {  
   alert("Last Name can't be blank");  
   return false;  
   }    
   else if(password.length<8 || password==null || password=="")
   {  
   alert("Password must be at least 8 characters long.");  
   return false;  
   }   

   var uname = document.abc.fname;
   var email = document.abc.email;  

   if(allLetter(fname))
     {
	    if(allLetter(fname))
            {
                if(allLetter(uname))  
		            {  
			            if(ValidateEmail(email))  
						{  
	 					}     
		            }
			}
      	}		
return false;   
} 	
	
	function allLetter(fname)  
	{   
	var letters = /^[A-Za-z]+$/;  
	if(fname.value.match(letters))  
	{  
	return true;  
	}  
	else  
	{	
	alert('First Name must have alphabet characters only');  
	fname.focus();  
	return false;  
	}  
	}
	
	function allLetter(lname)  
	{   
	var letters = /^[A-Za-z]+$/;  
	if(lname.value.match(letters))  
	{  
	return true;  
	}  
	else  
	{	
	alert('Last Name must have alphabet characters only');  
	lname.focus();  
	return false;  
	}  
	}
	
	function alphanumeric(uname)  
	{   
	var letters = /^[0-9a-zA-Z]+$/;  
	if(uname.value.match(letters))  
	{  
	return true;  
	}  
	else  
	{  
	alert('User name must have alphanumeric characters only');  
	uname.focus();  
	return false;  
	}  
	}   
	
	function ValidateEmail(email)  
	{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(email.value.match(mailformat))  
	{  
	return true;  
	}  
	else  
	{  
	alert("You have entered an invalid email address!");  
	email.focus();  
	return false;  
	}  
	}