package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> listOfUsers = new ArrayList<>();
	private static UserService userService;
	
	
	
	private UserService() {
		
	}


	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	
	public List<User> getList(){
			return listOfUsers;
	}
	
	public void saveUser(User u) {
		listOfUsers.add(u);
	}
	
	public User getUser(String email) {
		return listOfUsers.stream().filter(e->e.getEmail().equals(email)).findAny().orElse(null);
	}
}
