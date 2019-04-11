<html>
<head>
<script  src="http://code.jquery.com/jquery-1.10.1.min.js">
    
    </script>
    
<script type="text/javascript">


var prefix = '/spring-rest-with-ajax';


$(document).ready(function(){
	
	
	
		$('#SearchBy').on('input', function() {
			
			var rowdata = $('#SearchBy').val();
			
	        $.ajax({
	            type: 'GET',
	            url:  'MyData/rowselection',
	            data: {'rowdata' : rowdata },
	            contentType: "application/json; charset=utf-8",
	            
	            success: function(result) {

	                //alert('At ' + result.time + ': ' + result.msg);
					alert(result);
	               $("p").html(result);
	            	//$.each(tags, function(result) {  
	            		 // console.log(tag);
	            		//});
	          
	            },
	            
	            error: function(jqXHR, textStatus, errorThrown) {
	            	$("p").html(jqXHR.status + ' ' + jqXHR.responseText);
	            	//console.log (jqXHR.status + ' ' + jqXHR.responseText);
	                //alert(jqXHR.status + ' ' + jqXHR.responseText);
	            }
	       });
			
			});//end of .on(input)
	});//end of $(document)

var RestGet = function() 
{
		
		
    $.ajax({
        type: 'GET',
        url:  'MyData/' + Date.now(),
        dataType: 'json',
        async: true,
        success: function(result) {
            //alert('At ' + result.time + ': ' + result.msg);
            alert (result);
        	$.each(tags, function(result) {  
        		  console.log(tag);
        		});
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
        	 $("p").html(jqXHR.status + ' ' + jqXHR.responseText);
        	//console.log (jqXHR.status + ' ' + jqXHR.responseText);
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
   });
        /*$.ajax({
        type: 'GET',
        url:  'MyData/' + Date.now(),

        dataType: 'json',
        async: true,
        success: function(result) {
            //alert('At ' + result.time + ': ' + result.msg);

           $("p").html(result);
        	//$.each(tags, function(result) {  
        		 // console.log(tag);
        		//});
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
        	 $("p").html(jqXHR.status + ' ' + jqXHR.responseText);
        	//console.log (jqXHR.status + ' ' + jqXHR.responseText);
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
   });*/
}
 
var RestPut = function() {
 
    var JSONObject= {
        'time': Date.now(),
        'message': 'User PUT call !!!'
    };
 
    $.ajax({
        type: 'PUT',
        url:  'MyData/',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: true,
        success: function(result) {
            alert('At ' + result.time
                + ': ' + result.msg);
            
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}
 
var RestPost = function() {
        $.ajax({
        type: 'POST',
        url:  'MyData',
        dataType: 'json',
        async: true,
        success: function(result) {
        	

        	
        	
            alert('At ' + result.time
                + ': ' + result.msg);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}
 
var RestDelete = function() {
        $.ajax({
        type: 'DELETE',
        url:  'MyData/' + Date.now(),
        dataType: 'json',
        async: true,
        success: function(result) {
            alert('At ' + result.time
                + ': ' + result.msg);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}


</script>


</head>
<body>
<h1>Welcome To REST With Ajax !!!</h1>
<input id ="SearchBy"  type = text/>
<br>
<button type='button' onclick='RestGet()'>GET</button>
<button type='button' onclick='RestPut()'>PUT</button>
<button type='button' onclick='RestPost()'>POST</button>
<button type='button' onclick='RestDelete()'>DELETE</button>
<p> This issssss</p>
 <p id="dvHospitals"> This is a paragraph</p>
</body>
</html>
