package ua.lviv.lgs.main;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class Main {
	public static void main(String[] args) {
		UserService userservice = new UserServiceImpl();
		userservice.create(new User("a","b","c","d"));
		//userservice.read(null);
		//userservice.update(null);
		//userservice.readall();
		//userservice.delete(null);
	} 
}
