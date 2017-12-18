function validate()
{
   var uname1=document.abc.uname1.value;  
   var password1=document.abc.password1.value;  
   if (uname1==null || uname1=="")
   {  
   alert("User Name can't be blank");  
   return false;  
   }    
   else if(password1.length<8 || password1==null || password1=="")
   {  
   alert("password must be at least 8 characters long.");  
   return false;  
   }
}