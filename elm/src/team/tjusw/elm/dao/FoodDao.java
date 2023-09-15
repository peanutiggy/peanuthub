package team.tjusw.elm.dao;
import java.util.List;

import team.tjusw.elm.po.Food;


public interface FoodDao {
	public List<Food> listFoodByBusinessId(Integer businessId) throws Exception;
}
