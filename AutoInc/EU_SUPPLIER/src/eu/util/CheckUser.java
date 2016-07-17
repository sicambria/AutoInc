package eu.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import eu.util.User;
import eu.util.Users;

public class CheckUser {

	public static Boolean login(String email, String password) throws JAXBException{
		
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		File file = new File(Directories.users());
		
		Users users = (Users) unmarshaller.unmarshal(file);
		List<User> data = users.getUsers();
		
		Boolean checkFlag = false;
		
		for (User user : data) {
			System.out.println(user.getEmail());
			if(user.getEmail().equals(email)){
				if(user.getPassword().equals(password)){
					checkFlag = true;
				}
			}
		}
		
		return checkFlag;
	}
	
}
