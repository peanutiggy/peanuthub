package team.tjusw.elm.jdbc_proj.view.impl;

import java.sql.SQLException;
import java.util.Scanner;
import team.tjusw.elm.jdbc_proj.dao.AdminDao;
import team.tjusw.elm.jdbc_proj.dao.impl.AdminDaoImpl;
import team.tjusw.elm.jdbc_proj.po.Admin;
import team.tjusw.elm.jdbc_proj.view.AdminView;

public class AdminViewImpl implements AdminView{
	private Scanner input = new Scanner(System.in);
	
	@Override
	public Admin login() {
		System.out.println("请输入管理员名称：");
		String adminName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		AdminDao dao = new AdminDaoImpl();
		try {
			return dao.get(adminName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}