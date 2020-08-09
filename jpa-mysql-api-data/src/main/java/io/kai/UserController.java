package io.kai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// make this as rest Controller

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDAO userDAO;

	// to test our service is up and running
	@GetMapping
	public String check() {
		return "Hello~~~";
	}
	
	/*
	 * this method return list of usernames
	 * @return usernameList
	 */
	@GetMapping(path="/getUserNames")
	public String getAllUserNames() {
		return userDAO.getAllUser().toString();
	}
	
	/*
	 * this method return list of usernames
	 * @return count
	 */
	@GetMapping(path="/getCountUsersSeverit")
	public String getAllUser() {
		return userDAO.getCountByIpAndSeverit().toString();
	}
}
