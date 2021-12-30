package org.jdmp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jdmp.entity.User;

public class UserModel {
	
	private static DbModel dbm = null;
	
	public UserModel() {
		dbm = new DbModel();
	}
	
	public ArrayList<User> getAllUsers(){
		ArrayList<User> theList = new ArrayList<User>();
		ResultSet allUsers = dbm.getResultFromQuery("select * from users");
		try {
			while(allUsers.next()) {
				theList.add(new User(allUsers.getInt(1), allUsers.getString(2)));
			}
			return theList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteUser(int userID) {
		return dbm.executeQuery("delete from users WHERE userID = "+userID);
	}
	
	public boolean AddUser(User user) {
		return dbm.executeQuery("insert into users(userID, userName) values("+user.getUserID()+",'"+user.getUserName()+"')");
	}
	
}
