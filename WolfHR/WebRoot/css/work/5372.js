document.onreadystatechange = function(){ 
	try
	{
	   if(document.getElementsByName('startDate')[0] != null)
          document.getElementsByName('startDate')[0].onpropertychange = countValue; 
       if(document.getElementsByName('endDate')[0] != null)
          document.getElementsByName('endDate')[0].onpropertychange = countValue;  
       if(document.getElementsByName('startTime')[0] != null)
          document.getElementsByName('startTime')[0].onpropertychange = countValue; 
       if(document.getElementsByName('endTime')[0] != null)
          document.getElementsByName('endTime')[0].onpropertychange = countValue; 
	}
	catch (e)
	{
	}
  
}

function countValue() {
  
  var startStr = document.getElementsByName('startDate')[0].value;
  var endStr
  //if (document.getElementsByName('more')[0].checked){
  if(false){
	endStr = document.getElementsByName('endDate')[0].value;
    } else {
	endStr = document.getElementsByName('startDate')[0].value;
   }
  if(document.getElementsByName('startTime')[0].value== '')
   document.getElementsByName('startTime')[0].value='18:00'; 
  var startT = document.getElementsByName('startTime')[0].value;
if(document.getElementsByName('endTime')[0].value== '')
  document.getElementsByName('endTime')[0].value='20:00';
  var endT = document.getElementsByName('endTime')[0].value;
 

  var startDateStr = startStr + ' ' + startT;
  var endDateStr = endStr + ' ' + endT;
  var startDate = new Date(Date.parse(startDateStr.replace(/-/g,   "/"))); 
  var endDate = new Date(Date.parse(endDateStr.replace(/-/g,   "/"))); 

 var hour= (endDate - startDate)/(3600*1000);
  document.getElementById('countHour').value = hour.toFixed(1);
  }
