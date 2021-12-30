<%@include file="includes/header.jsp" %>
<form method="post" action="#">
	<div>
		<label>ID</label>
		<input type="text" name="userID" required>
	</div>
	<div>
		<label>Name</label>
		<input type="text" name="userName" required>
	</div>
	<div>
		<input type="submit" value="Add"/>
	</div>
	<input type="hidden" name="process" value="addUser"/>
</form>
<%@include file="includes/footer.jsp" %>