function validate()
{
 if( document.abc.depart.value == "-1" )
   {
     alert( "Please provide departure city!" );
   }
   if( document.abc.arrive.value == "-1" )
   {
     alert( "Please provide arrival city!" );
   }
   if( document.abc.depart.value==document.abc.arrive.value)
   {
	alert( "Departure city and arrival city cannot be same!" );
   }
   if( document.abc.class.value == "-1" )
   {
     alert( "Please select your class!" );
   }
   var x= document.abc.jtype.value;
				if(x.localeCompare("on")!=0)
					{
					    alert("Please select your Journey Type");
					}
	var y= document.abc.concession.value;
				if(y.localeCompare("on")!=0)
					{
					    alert("Please select whether you are from army");
					}
}