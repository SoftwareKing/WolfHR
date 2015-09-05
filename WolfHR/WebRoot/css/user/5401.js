

function document.onreadystatechange()
{
if (document.readyState=="complete") {
      var value = document.getElementsByName("moreQueryDisplay")[0].value;
      if(value == "1") {
      document.getElementById("query_1").style.display="";
      document.getElementById("query_2").style.display="";
      document.getElementById("moreQuery").style.display="none";
      document.getElementById("littleQuery").style.display="";
   }
   }
}



function getMoreQuery() {
  document.getElementById("query_1").style.display="";
  document.getElementById("query_2").style.display="";
  document.getElementById("moreQuery").style.display="none";
  document.getElementById("littleQuery").style.display="";
  document.getElementsByName("moreQueryDisplay")[0].value="1";
  submitButton('MORE');
 
}

function setLittleQuery() {
  document.getElementById("query_1").style.display="none";
  document.getElementById("query_2").style.display="none";
  document.getElementById("moreQuery").style.display="";
  document.getElementById("littleQuery").style.display="none";
  document.getElementsByName("moreQueryDisplay")[0].value="0";
 submitButton('LITTLE');
}