package team.tjusw.elm.jdbc_proj.dao;

import java.sql.SQLException;
import java.util.List;

import team.tjusw.elm.jdbc_proj.po.Business;

/**
 * 数据库中商家相关的接口
 * 
 * @author Abdusalam-Ablimit
 * 
 */
public interface BusinessDao {
	/**
	 * 从数据库中查找商家信息，最后以List的形式返回
	 * 
	 * @param id            可以为null，如果是null则根据其他参数模糊查询
	 * @param name          商家名称，支持模糊查询，可以为null
	 * @param address       商家地址，支持模糊查询，可以为null
	 * @param explain       商家简介，支持模糊查询，可以为null
	 * @param startPrice    起送费，返回起送费不大于此参数值的商家，可以为null
	 * @param deliveryPrice 配送费，返回配送费不大于此参数值的商家，可以为null
	 * @return 如果数据库中有商家匹配，则封装成Business类对象，以List的形式返回；参数全为null则返回全部商家；没有商家匹配则返回空的List
	 */
	public List<Business> get(Integer id, String name, String address, String explain,Double startPrice,Double delivertPrice)throws SQLException;

	/**
	 * 在数据库中删除编号为id的商家
	 * 
	 * @param id 商家在数据库中的编号
	 * @return 200: 成功删除数据库中对应的商家; 404: 数据库中未找到参数对应的商家; 400: 参数格式错误，参数为null时返回; 500: 数据库系统内部错误
	 */

	/**
	 * 用编号和密码获取商家
	 * 
	 * @param id     			商家编号，不能为null
	 * @param password 			商家密码，不能为null
	 * @return null: 输入格式有误、没有与用户名和密码匹配的商家; Business类对象: 名称和密码匹配成功
	 * @throws SQLException 数据库出现错误
	 */
	public Business get(Integer id, String password) throws SQLException;


	public StatusCode delete(Integer id)throws SQLException;

	/**
	 * 在数据库中新建一个商家
	 * 
	 * @param name          商家名称，不可以为null
	 * @param address       商家地址，可以为null
	 * @param explain       商家简介，可以为null
	 * @param startPrice    起送费，可以为null
	 * @param deliveryPrice 配送费，可以为null
	 * @param password 
	 * @return 201: 成功在数据库中创建商家; 400: 参数的格式错误 ; 500: 数据库系统内部错误
	 */
	public StatusCode put(String name, String address, String explain, Double startPrice, Double deliveryPrice, String password)throws SQLException;

	/**
	 * 
	 * @param id            商家编号，主键，用于在数据库中定位，不可缺省
	 * @param name          修改后的名称，null意味着不修改
	 * @param address       修改后的地址，null意味着不修改
	 * @param explain       修改后的简介，null意味着不修改
	 * @param startPrice    起送费，null意味着不修改
	 * @param deliveryPrice 配送费，null意味着不修改
	 * @return 201: 成功修改; 400: 参数格式错误; 404: 数据库中不存在编号为id的商家; 500: 数据库系统内部错误
	 */
	public StatusCode update(Integer id, String name, String address, String explain, Double startPrice,
			Double deliveryPrice,String password)throws SQLException;
}
