package team.tjusw.elm.jdbc_proj.view;

public interface FoodView {
	public void showFoodList(Integer businessId);
	public void addFood(Integer businessId);
	public void updateFood(Integer businessId);
	public void removeFood(Integer businessId);
}