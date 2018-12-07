<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<%@ page session="false" %>
<html>
<head>
<script>
$(function(){
	$("#Submit-btn").click(function (){
		 var password = $("#password").val();
		 var confirmPassword = $("#confirmpassword").val();
		 if(password==confirmPassword){
			 $("customer").submit();
			
			 }else{
				 alert("Passwords do not match.");
				 return false;
				 }
				 
		 
		});
});
</script>
	
</head>
<body>
<h1>
	Welcome
</h1>

<form:form commandName="customer">
Username:<form:input path="username"/><br><br>
Password:<form:password path="password"/><br><br>
Confirm Password<input type="password" id ="confirmpassword"><br>
<input type="submit" id= "Submit-btn" value="submit"><br>

</form:form>
</body>
</html>
