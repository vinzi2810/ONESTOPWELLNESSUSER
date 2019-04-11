<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script  src="http://code.jquery.com/jquery-1.10.1.min.js">

    </script>
    
          <style>
         table{
           width: 50%;
           margin: 25px 0;
           border-collapse: collapse;
         }
         table, th, td{
           border: 1px solid #6C220B;
         }
         table th, table td{
           padding: 8px;
           text-align: left;
         }
         tbody  :hover {
 			 background-color: #b3d9ff;
		}

		td, th {
 			 position: relative;
			}
		#doctorSelection {
				display: block;
				overflow: auto;
			}
      </style>
    
<script type="text/javascript">



$(document).ready(function(){
	


$('#SearchBy').on('input', function() {
	
	
	
	var name = $('#SearchBy').val();
	var v = "";
	
	 if ($("#SearchBy").val() != '') {
           $.ajax({
               url: 'MyData/' + 't',
               //data: { 'name': $("#SearchBy").val() },
               contentType: "application/json; charset=utf-8",
               data: {'name' : name },
              // data: {'name' : "done"  },

              
               success: function (result) {
            	  // r = result;	            	
                   //$('#dvBanks').html(r);
                  //alert (result);
                  var hospitalList="";
                  for (i = 0; i < result.length; i++) { 
                	  //text += cars[i] + "<br>";
                	//  alert (result[i]);
                	  //r += '<p>' + result[i] + '</p><br>' ;
                	  hospitalList =  hospitalList+ "<tr><td id='name'>" + result[i].hospitalName + "</td>+<td>" + result[i].hospitalLocation + "</td></tr>";
                	
                	  //var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + subject + "</td></tr>";
                	}
                  hospitalList = "<table id='tableId'><thead><tr><th>Hospital</th><th>Location</th></thead><tbody>"+hospitalList;
      		       hospitalList = hospitalList+ "</tbody></table>";
                  //alert (hospitalList);
                  $("#dvHospitals").html(hospitalList);
                  

               				},
               				
               				
               error: function(jqXHR, textStatus, errorThrown) {
               	$("p").html(jqXHR.status + ' ' + jqXHR.responseText);
						//console.log (jqXHR.status + ' ' + jqXHR.responseText);
              	   alert(jqXHR.status + ' ' + jqXHR.responseText);
										}
               
               
           });//end of $ajax
       
       }//end of if
	});//end of .on(input)
	
	
	
	
	
$(document).on("click", "#tableId tbody tr ", function() {
    //some think
    //var rowdata = $(this).text();
    var rowdata = $(this).find('td:eq(0)').text();
    $("#SearchBy").val(rowdata);
    $("#dvHospitals").remove();
   // alert ($(this).find('td:eq(0)').text());
    
    $.ajax({
        type: 'GET',
        url:  'MyData/rowselection',

        async: true,
        data: {'rowdata' : rowdata },
        success: function(result) {
        	
        	
        	result = result +"finally!";

            alert (result);
            

        	//$.each(tags, function(result) {  
        		  //console.log(tag);
        		//});
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
        	 //$("p").html(jqXHR.status + ' ' + jqXHR.responseText);
        	//console.log (jqXHR.status + ' ' + jqXHR.responseText);
            //alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
   });
	
    
});//end of on click of row


$('#SearchDoctors').on('input', function() {
	
	
	
	//var name = $('#SearchDoctors').val();
	var hosname =  $('#SearchBy').val();
	var v = "";
	
	 if ($("#SearchDoctors").val() != '') {
           $.ajax({
               url: 'MyData/doctorselection',
               //data: { 'name': $("#SearchBy").val() },
               contentType: "application/json; charset=utf-8",
               data: {'hosname' : hosname },
              // data: {'name' : "done"  },

              
               success: function (result) {
            	  // r = result;	            	
                   //$('#dvBanks').html(r);
                  //alert (result);
                  var doctorList="";
                  for (i = 0; i < result.length; i++) { 
                	  //text += cars[i] + "<br>";
                	//  alert (result[i]);
                	  //r += '<p>' + result[i] + '</p><br>' ;
                	  //doctorList =  doctorList+ "<tr><td id='name'>" + result[i].doctorName + "</td>+<td>" + result[i].specialization + "</td></tr>";
                	  doctorList =  doctorList+"<div class='card' id ='card' style='width: 18rem;  border:1px solid black'><img class='card-img-top' src='...' alt='Card image cap'><div class='card-body'><h5 class='card-title' id ='card' >"+result[i].doctorName+"</h5><p class='card-text'>"+result[i].specialization+"</p></div></div><br>";
                	
                	  //var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + subject + "</td></tr>";
                	}
                  //doctorList = "<table id='tableId'><thead><tr><th>Doctor</th><th>Specialization</th></thead><tbody>"+doctorList;
      		       //doctorList = doctorList+ "</tbody></table>";
                  //alert (hospitalList);
                  $("#doctorSelection").html(doctorList);
                  

               				},
               				
               				
               error: function(jqXHR, textStatus, errorThrown) {
               	$("p").html(jqXHR.status + ' ' + jqXHR.responseText);
						//console.log (jqXHR.status + ' ' + jqXHR.responseText);
              	   alert(jqXHR.status + ' ' + jqXHR.responseText);
										}
               
               
           });//end of $ajax
       
       }//end of if
	});//end of .on(input)
	
	
	
	$(".card").click( function() {
	    //some think
	    //var rowdata = $(this).text();
	    var carddata = $(this).text();
	    $("#SearchDoctors").val(rowdata);
	    $("#doctorSelection").remove();
	   alert ("card selected");
	    
	    $.ajax({
	        type: 'GET',
	        url:  'MyData/cardselection',

	        async: true,
	        data: {'carddata' : carddata },
	        success: function(result) {
	        	
	        	
	        	result = result +"finally!";

	            alert (result);
	            

	        	//$.each(tags, function(result) {  
	        		  //console.log(tag);
	        		//});
	        },
	        
	        error: function(jqXHR, textStatus, errorThrown) {
	        	 //$("p").html(jqXHR.status + ' ' + jqXHR.responseText);
	        	//console.log (jqXHR.status + ' ' + jqXHR.responseText);
	            //alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
		
	    
	});//end of on click of card
	
});//end of $(document)


</script>

</head>
<body>


    
<input id ="SearchBy"  type = text/>

<br>
<br>

<input id ="SearchDoctors"  type = text/>

<br>
 <div id="dvHospitals">
 
 
 </div>
 
 <br>
 
 <div id="doctorSelection"> 
 </div>

</body>

</html>
