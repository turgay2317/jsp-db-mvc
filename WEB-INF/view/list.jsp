<%@include file="includes/header.jsp" %>


<table>
	<tr>
	<th>UserID</th>
	<th>UserName</th>
	<th>Actions</th>
	</tr>
	
<%

ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");

for(User user: userList){
	out.println("<tr><td>#"+user.getUserID()+"</td><td>"+user.getUserName()+"</td><td><a href='?page=Delete&userID="+user.getUserID()+"'>Delete</a></td></tr>");
}


%>
</table>
<%@include file="includes/footer.jsp" %>