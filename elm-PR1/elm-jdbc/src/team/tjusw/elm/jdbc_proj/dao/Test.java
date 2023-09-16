package team.tjusw.elm.jdbc_proj.dao;

import java.sql.SQLException;
import java.util.List;

import team.tjusw.elm.jdbc_proj.dao.impl.AdminDaoImpl;
import team.tjusw.elm.jdbc_proj.dao.impl.BusinessDaoImpl;
import team.tjusw.elm.jdbc_proj.dao.impl.FoodDaoImpl;
import team.tjusw.elm.jdbc_proj.po.Admin;
import team.tjusw.elm.jdbc_proj.po.Business;
import team.tjusw.elm.jdbc_proj.po.Food;

public class Test {
	static boolean testAdmin() {
		AdminDao dao = new AdminDaoImpl();

		try {
			List<Admin> res = dao.get();
			if (res.size() != 2)
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Admin res = dao.get("abdusalam","123");
			if (res==null)
				return false;
			if(res.getId()!=1)
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Admin res = dao.get("abdusalama","123");
			if (res!=null)
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Admin res = dao.get("abdusalam",null);
			if (res!=null)
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Admin res = dao.get(null,"123");
			if (res!=null)
				return false;
			
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
	static boolean testFood()
	{
		
		FoodDao dao = new FoodDaoImpl();

		try {
			List<Food> res = dao.get(null, null, null, null, null, null);
			if (res.size() != 7)
				return false;
			res = dao.get(1, null, null, null, null, null);
			if (!res.get(0).getName().equals("纯肉鲜肉（水饺）"))
				return false;
			
			res = dao.get(null,"瓜鸡蛋", null, null, null, null);
			if(res.get(0).getId()!=5)
				return false;
					
			res = dao.get(null,null, "菜鸡蛋虾", null, null, null);
			if(res.get(0).getId()!=4)
				return false;
			
			res = dao.get(null,null, null, 11.00, 15.50, null);
			if(res.size()!=2)
				return false;
			
			res = dao.get(null,null, null, null,null, 10001);
			if(res.size()!=5)
				return false;
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Food food = new Food(0,"test","test",99.0,10001);
			if(dao.put(food)!=StatusCode.CREATED)
				return false;
			List<Food>ls = dao.get(null,"test", "test", null, null, null);
			if(ls==null || ls.isEmpty())
				return false;
			food = ls.get(0);
			food.setName("test1");
			food.setExplain("test1");
			food.setBusinessId(10002);
			food.setPrice(100.1);
			dao.update(food);
			food = dao.get(food.getId(), null, null, null, null, null).get(0);
			if(!food.getName().equals("test1") || !food.getExplain().equals("test1")||!food.getPrice().equals(100.1) || !food.getBusinessId().equals(10002))
				return false;
			if(dao.delete(food.getId())!=StatusCode.OK)
				return false;
		}catch (SQLException e) {
			return false;
		}
		
		return true;

	}
	static boolean testBusiness()
	{
		BusinessDao dao = new BusinessDaoImpl();
		
		try {
			List<Business> res = dao.get(null, null, null, null, null, null);
			if (res.size() != 7)
				return false;
			res = dao.get(10001, null, null, null, null, null);
			if (!res.get(0).getName().equals("万家饺子（软件园E18店）"))
				return false;
			
			res = dao.get(null,"当劳麦乐", null, null, null, null);
			if(res.get(0).getId()!=10003)
				return false;
					
			res = dao.get(null,null, "全运路53号麦当", null, null, null);
			if(res.get(0).getId()!=10003)
				return false;
			
			res = dao.get(null,null, null, "堡薯", null, null);
			if(res.get(0).getId()!=10003)
				return false;
			
			res = dao.get(null,null, null, null, 20.00, null);
			if(res.size()!=5)
				return false;
			
			res = dao.get(null,null, null, null,null, 3.50);
			if(res.size()!=4)
				return false;
		} catch (SQLException e) {
			return false;
		}
		
		try {
			Business business = new Business(0,"1","test_name","test_address","test_explain",2.33,6.66);
			if(dao.put(business.getName(),business.getAddress(),business.getExplain(),business.getStarPrice(),business.getDeliveryPrice(),business.getPassword())!=StatusCode.CREATED)
				return false;
			List<Business>ls = dao.get(null,"test_name",null, null, null, null);
			if(ls==null || ls.isEmpty())
				return false;
			business = ls.get(0);
			if(!business.getName().equals("test_name")||!business.getAddress().equals("test_address")||!business.getExplain().equals("test_explain")||!business.getPassword().equals("1")||!business.getStarPrice().equals(2.33)||!business.getDeliveryPrice().equals(6.66))
				return false;
			business.setName("test1");
			business.setExplain("test2");
			business.setAddress("test3");
			business.setPassword("123");
			business.setDeliveryPrice(111.1);
			business.setStartPrice(222.2);
			dao.update(business.getId(),business.getName(),business.getAddress(),business.getExplain(),business.getStarPrice(),business.getDeliveryPrice(),business.getPassword());
			ls = dao.get(null,"test1",null, null, null, null);
			if(ls==null || ls.isEmpty())
				return false;
			business = ls.get(0);
			if(!business.getName().equals("test1")||!business.getAddress().equals("test3")||!business.getExplain().equals("test2")||!business.getPassword().equals("123")||!business.getStarPrice().equals(222.2)||!business.getDeliveryPrice().equals(111.1))
				return false;
			if(dao.delete(business.getId())!=StatusCode.OK)
				return false;
		}catch (SQLException e) {
			return false;
		}
		
		
		return true;
	}
	
	public static void main(String[] argv) {

		if (testAdmin()) {
			System.out.println("Admin测试通过");
		}
		if (testFood()) {
			System.out.println("Food测试通过");
		}
		
		if (testBusiness()) {
			System.out.println("Business测试通过");
		}

	}
}
