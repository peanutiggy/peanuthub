package team.tjusw.elm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import team.tjusw.elm.po.Food;
import team.tjusw.elm.service.FoodService;
import team.tjusw.elm.service.impl.FoodServiceImpl;

public class FoodController {
	public Object listFoodByBusinessId(HttpServletRequest request) throws Exception {
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		FoodService service = new FoodServiceImpl();
		List<Food> list = service.listFoodByBusinessId(businessId);
		return list;
	}
}

