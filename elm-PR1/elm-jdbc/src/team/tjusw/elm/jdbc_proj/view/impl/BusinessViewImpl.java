package team.tjusw.elm.jdbc_proj.view.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import team.tjusw.elm.jdbc_proj.dao.BusinessDao;
import team.tjusw.elm.jdbc_proj.dao.StatusCode;
import team.tjusw.elm.jdbc_proj.dao.impl.BusinessDaoImpl;
import team.tjusw.elm.jdbc_proj.po.Business;
import team.tjusw.elm.jdbc_proj.view.BusinessView;

public class BusinessViewImpl implements BusinessView {

	private Scanner input = new Scanner(System.in);

	@Override
	public void listBusinessAll() {
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list;
		try {
			list = dao.get(null, null, null, null, null, null);
			System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
			for (Business b : list) {
				System.out.println(b.getId() + "\t" + b.getName() + "\t" + b.getAddress() + "\t" + b.getExplain() + "\t"
						+ b.getStarPrice() + "\t" + b.getDeliveryPrice());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void listBusiness() {
		String businessName = null;
		String businessAddress=null;
		String inputStr = null;
		System.out.println("是否需要输入商家名称关键词(y/n)：");
		inputStr = input.next();
		if (inputStr.equals("y")) {
			System.out.println("请输入商家名称关键词：");
			businessName = input.next();
		}

		System.out.println("是否需要输入商家地址关键词(y/n)：");
		inputStr = input.next();
		if (inputStr.equals("y")) {
			System.out.println("请输入商家地址关键词：");
			businessAddress = input.next();
		}

		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list;
		try {

			list = dao.get(null, businessName, businessAddress, null, null, null);
			System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
			for (Business b : list) {
				System.out.println(b.getId() + "\t" + b.getName() + "\t" + b.getAddress() + "\t" + b.getExplain() + "\t"
						+ b.getStarPrice() + "\t" + b.getDeliveryPrice());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void saveBusiness() {
		System.out.println("请输入商家名称：");
		String businessName = input.next();
		System.out.println("请输入商家密码：");
		String password = input.next();
		BusinessDao dao = new BusinessDaoImpl();
		StatusCode stcode;
		try {
			stcode = dao.put(businessName, null, null, null, null,password);
			if (stcode == StatusCode.CREATED) {
				List<Business> ls = dao.get(null, businessName, null, null, null, null);
				if (ls != null)
					System.out.println("新建商家成功！商家编号为：" + ls.get(ls.size()-1).getId());
			} else {
				System.out.println("新建商家失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removeBusiness() {
		System.out.println("请输入商家编号：");
		int businessId = input.nextInt();
		BusinessDao dao = new BusinessDaoImpl();
		System.out.println("确认要删除吗(y/n)：");
		if (input.next().equals("y")) {
			StatusCode stcode;
			try {
				stcode = dao.delete(businessId);
				if (stcode == StatusCode.OK) {
					System.out.println("删除商家成功！");
				} else {
					System.out.println("删除商家失败！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public Business login() {
		System.out.println("请输入商家编号：");
		int businessId = input.nextInt();
		System.out.println("请输入密码：");
		String password = input.next();
		BusinessDao dao = new BusinessDaoImpl();
		try {
			return dao.get(businessId, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void showBusiness(Integer businessId) {
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> ls;
		try {
			ls = dao.get(businessId, null, null, null, null, null);
			if (ls == null)
				throw new RuntimeException("数据库系统错误");
			else if (ls.size() == 0)
				System.out.println("没有找到编号为" + businessId + "的商家.");
			else
				System.out.println(ls.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editBusiness(Integer businessId) {
		// 先将商家信息查询出来显示，然后用户才能更新
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list;
		try {
			list = dao.get(businessId, null, null, null, null, null);
			if (list.size() == 0) {
				System.out.println("无此商家信息.");
				return;
			}
			Business business = list.get(0);
			System.out.println(business);
			String inputStr = "";

			System.out.println("是否修改商家名称(y/n)：");
			inputStr = input.next();
			if (inputStr.equals("y")) {
				System.out.println("请输入新的商家名称：");
				business.setName(input.next());
			}

			System.out.println("是否修改商家地址(y/n)：");
			inputStr = input.next();
			if (inputStr.equals("y")) {
				System.out.println("请输入新的商家地址：");
				business.setAddress(input.next());
			}

			System.out.println("是否修改商家介绍(y/n)：");
			inputStr = input.next();
			if (inputStr.equals("y")) {
				System.out.println("请输入新的商家介绍：");
				business.setExplain(input.next());
			}

			System.out.println("是否修改起送费(y/n)：");
			inputStr = input.next();
			if (inputStr.equals("y")) {
				System.out.println("请输入新的起送费：");
				business.setStartPrice(input.nextDouble());
			}

			System.out.println("是否修改配送费(y/n)：");
			inputStr = input.next();
			if (inputStr.equals("y")) {
				System.out.println("请输入新的配送费：");
				business.setDeliveryPrice(input.nextDouble());
			}

			StatusCode stcode = dao.update(business.getId(), business.getName(), business.getAddress(),
					business.getExplain(), business.getStarPrice(), business.getDeliveryPrice(),null);
			if (stcode == StatusCode.OK) {
				System.out.println("\n修改商家信息成功！\n");
			} else {
				System.out.println("\n修改商家信息失败！\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateBussinessPassword(Integer businessId) {
		BusinessDao dao = new BusinessDaoImpl();
		List<Business> list;
		try {
			list = dao.get(businessId, null, null, null, null, null);
			if (list.size() == 0) {
				System.out.println("无此商家信息.");
				return;
			}
			Business business = list.get(0);
			
			System.out.println("\n请输入旧密码：");
			String oldPass = input.next();
			System.out.println("\n请输入新密码：");
			String password = input.next();
			System.out.println("\n请再次输入新密码：");
			String beginPassword = input.next();

			if (!business.getPassword().equals(oldPass)) {
				System.out.println("\n旧密码输入错误！");
			} else if (!password.equals(beginPassword)) {
				System.out.println("\n两次输入密码不一致！");
			} else {
				StatusCode stcode = dao.update(businessId,null,null,null,null,null, beginPassword);
				if (stcode == StatusCode.OK) {
					System.out.println("\n修改密码成功！");
				} else {
					System.out.println("\n修改密码失败！");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
