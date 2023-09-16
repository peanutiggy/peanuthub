package team.tjusw.elm.jdbc_proj.dao;

import java.sql.SQLException;
import java.util.List;
import team.tjusw.elm.jdbc_proj.po.Food;

/**
 * 
 * @author Abdusalam-Ablimit
 *
 */
public interface FoodDao {

	/**
	 * 
	 * @param id         食品编号，主键，null时可根据其他参数模糊查询
	 * @param name       食品的名称，模糊查询，可以为null
	 * @param explain    食品简介，模糊查询，可以为null
	 * @param minPrice   价格下界，可以为null
	 * @param maxPrice  价格上界，可以为null
	 * @param businessId 所属商家的编号
	 * @return null 数据库相关的错误，提供的参数错误
	 * @return 空的List 参数正确，但是数据库中没有匹配的食品
	 * @return 非空的List 数据库中存在匹配的食品
	 * @throws SQLException TODO
	 * 
	 */
	public List<Food> get(Integer id, String name, String explain, Double minPrice, Double maxPrice,
			Integer businessId) throws SQLException;

	/**
	 * 
	 * @param name       商家名称，不可以是null
	 * @param explain    商家简介，可以是null
	 * @param price      食品价格，不可以是null
	 * @param businessId 食品所属商家的编号，不可以为null
	 * @return 201 成功往数据库中添加食品
	 * @return 400 参数的格式错误
	 * @return 404 商家编号不存在
	 * @return 500 数据库系统内部错误
	 * @throws SQLException TODO
	 */
	public StatusCode put(String name, String explain, Double price, Integer businessId) throws SQLException;
	
	/**
	 * 
	 * @param food 一个有效的food对象，id可以为空
	 * @return 跟上方的重载一样
	 * @throws SQLException
	 */
	public StatusCode put(Food food)throws SQLException;

	/**
	 * 
	 * @param id 食品编号
	 * @return 200 成功删除数据库中对应的食品
	 * @return 404 数据库中未找到参数对应的食品
	 * @return 400 参数格式错误，参数为null时返回
	 * @return 500 数据库系统内部错误
	 * @throws SQLException TODO
	 */
	public StatusCode delete(Integer id) throws SQLException;

	/**
	 * 
	 * @param id         食品编号，主键，用于定位，不可缺省
	 * @param name       修改后的食品名称，null意味着不修改
	 * @param explain    修改后的食品简介，null意味着不修改
	 * @param price      修改后的价格，null意味着不修改
	 * @param businessId 修改后的所属商家，null意味着不修改
	 * @return 201 成功修改
	 * @return 400 参数格式错误
	 * @return 404 数据库中不存在编号为id的食品或编号为businessId的商家
	 * @return 500 数据库系统内部错误
	 * @throws SQLException TODO
	 */
	public StatusCode update(Integer id, String name, String explain, Double price, Integer businessId) throws SQLException;
	
	public StatusCode update(Food food) throws SQLException;

}
