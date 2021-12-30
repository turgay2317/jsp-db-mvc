package org.jdmp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdmp.entity.User;
import org.jdmp.model.UserModel;


@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserModel usm;


    public UserController() {
        usm = new UserModel();
    }
    
    public String setPath(String path) {
    	return "/WEB-INF/view/"+path;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageName = request.getParameter("page") == null ? "Home" : request.getParameter("page");
		String pagePath = setPath("index.jsp");
		
		switch(pageName) {
			case "Home":
				pagePath = setPath("index.jsp");
			break;
			
			case "List":
				ArrayList<User> uslist = (ArrayList<User>) usm.getAllUsers();
				request.setAttribute("userList", uslist);
				pagePath = setPath("list.jsp");
			break;
			
			case "Add":
				pagePath = setPath("add.jsp");
			break;
			
			case "Delete":
				Integer userID = Integer.parseInt(request.getParameter("userID"));
				usm.DeleteUser(userID);
				ArrayList<User> uslist_after = (ArrayList<User>) usm.getAllUsers();
				request.setAttribute("userList", uslist_after);
				pagePath = setPath("list.jsp");
			break;
			
			default:
				pagePath = setPath("index.jsp");
			break;
		}
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher(pagePath);
	    rDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String process = req.getParameter("process");
		if(process.equals("addUser")) {
			Integer newUserID = Integer.parseInt(req.getParameter("userID"));
			String newUserName = req.getParameter("userName");
			User newUser = new User(newUserID, newUserName);
			usm.AddUser(newUser);
			resp.getWriter().println("User adding is successful. Redirecting...");
			resp.setHeader("Refresh", "2;url="+req.getContextPath()+"/?page=List");
		}else {
			resp.getWriter().println("Invalid post");
		}
	}


}
