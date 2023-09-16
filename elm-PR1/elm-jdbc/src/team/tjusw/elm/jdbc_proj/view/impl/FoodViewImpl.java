package team.tjusw.elm.jdbc_proj.view.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import team.tjusw.elm.jdbc_proj.dao.FoodDao;
import team.tjusw.elm.jdbc_proj.dao.StatusCode;
import team.tjusw.elm.jdbc_proj.dao.impl.FoodDaoImpl;
import team.tjusw.elm.jdbc_proj.po.Food;
import team.tjusw.elm.jdbc_proj.view.FoodView;

public class FoodViewImpl implements FoodView{
	private Scanner input = new Scanner(System.in);
	@Override
	public void showFoodList(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		List<Food> list;
		try {
			list = dao.get(null, null, null, null, null, businessId);
			System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
			for(Food food : list) {
				System.out.println(food.getId()+"\t"+food.getName()+"\t"+food.getExplain()+"\t"+food
						.getPrice());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addFood(Integer businessId) {
		Food food = new Food();
		System.out.println("请输入食品名称：");
		food.setName(input.next());
		System.out.println("请输入食品介绍：");
		food.setExplain(input.next());
		System.out.println("请输入食品价格：");
		food.setPrice(input.nextDouble());
		food.setBusinessId(businessId);
		FoodDao dao = new FoodDaoImpl();
		try {
			StatusCode stcode = dao.put(food);
			if(stcode==StatusCode.CREATED) {
				System.out.println("\n新增食品成功！\n");
			}else {
				System.out.println("\n新增食品失败！\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateFood(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		try {
			List<Food> list = dao.get(null, null, null, null, null, businessId);
			if(list.size()==0) {
				System.out.println("没有任何食品！");
			}else {
				System.out.println("请选择要更新的食品编号：");
				int foodId = input.nextInt();
				Food food = null;
				for(Food e:list)
					if(e.getId()==foodId)
						food = e;
				if(food==null)
				{
					System.out.println("没有这个编号的食品.");
					return;        //需完善
				}
				System.out.println(food);
				String inputStr = "";
				System.out.println("是否更新食品名称(y/n)：");
				inputStr = input.next();
				if(inputStr.equals("y")) {
					System.out.println("请输入新的食品名称：");
					food.setName(input.next());
				}
				System.out.println("是否更新食品介绍(y/n)：");
				inputStr = input.next();
				if(inputStr.equals("y")) {
					System.out.println("请输入新的食品介绍：");
					food.setExplain(input.next());
				}
				System.out.println("是否更新食品价格(y/n)：");
				inputStr = input.next();
				if(inputStr.equals("y")) {
					System.out.println("请输入新的食品价格：");
					food.setPrice(input.nextDouble());
				}
				StatusCode stcode = dao.update(food);
				if(stcode == StatusCode.OK) {
					System.out.println("\n修改食品成功！\n");
				}else {
					System.out.println("\n修改食品失败！\n");
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void removeFood(Integer businessId) {
		FoodDao dao = new FoodDaoImpl();
		
		try {
			List<Food> list = dao.get(null, null, null, null, null, businessId);
			if(list.size()==0) {
				System.out.println("没有任何食品！");
			}else {
				System.out.println("请选择要删除的食品编号：");
				int foodId = input.nextInt();
				System.out.println("确认要删除吗(y/n)：");
				if(input.next().equals("y")) {
					StatusCode stcode = dao.delete(foodId);
					if(stcode==StatusCode.OK) {
						System.out.println("\n删除食品成功！\n");
					}else {
						System.out.println("\n删除食品失败！\n");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}