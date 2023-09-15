package team.tjusw.elm.controller;

import javax.servlet.http.HttpServletRequest;

import team.tjusw.elm.po.User;
import team.tjusw.elm.service.UserService;
import team.tjusw.elm.service.impl.UserServiceImpl;

public class UserControler {
	public Object getUserByIdByPass(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserService service = new UserServiceImpl();
		User user = service.getUserByIdByPass(userId, password);
		return user;
	}

	public Object getUserById(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");
		UserService service = new UserServiceImpl();
		int result = service.getUserById(userId);
		return result;
	}

	public Object saveUser(HttpServletRequest request) throws Exception {
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));
		user.setUserName(request.getParameter("userName"));
		user.setUserSex(Integer.valueOf(request.getParameter("userSex")));
		UserService service = new UserServiceImpl();
		int result = service.saveUser(user);
		return result;
	}
}
