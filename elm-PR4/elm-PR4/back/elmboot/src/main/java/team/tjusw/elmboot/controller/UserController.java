package team.tjusw.elmboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.tjusw.elmboot.po.User;
import team.tjusw.elmboot.service.UserService;

@RestController
@RequestMapping("/UserControler")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/getUserByIdByPass")
	public Object getUserByIdByPass(User user) throws Exception {
		return userService.getUserByIdByPass(user);
		
	}

	@RequestMapping("/getUserById")
	public int getUserById(User user) throws Exception {
		return userService.getUserById(user.getUserId());
	}

	@RequestMapping("/saveUser")
	public int saveUser(User user) throws Exception {
		return userService.saveUser(user);
	}

}
