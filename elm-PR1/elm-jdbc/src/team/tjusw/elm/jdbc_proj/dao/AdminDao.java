package team.tjusw.elm.jdbc_proj.dao;
import java.sql.SQLException;
import java.util.List;


import team.tjusw.elm.jdbc_proj.po.Admin;
/**
 * 
 * @author Abdusalam-Ablimit
 *
 */
public interface AdminDao 
{
	
	/**
	 * 通过名称和密码获得Admin类对象
	 * @param name 管理员名称，不可以为null
	 * @param password 管理员密码，不可以为null
	 * @return null 参数错误、数据库内部错误，未找到匹配的管理员等
	 * @return Admin对象，找到了用户名和密码都匹配的管路员
	 * 
	 */
	public Admin get(String name,String password)throws SQLException;
	
	
	
	/**
	 * 获取数据库中全部管理员列表，封装成List<Admin>返回
	 * @return 空的List，数据库管理员表为空
	 * @return 非空的List，数据库管理员列表
	 */
	public List<Admin> get()throws SQLException;
	
	
	/** 
	 * 向数据库中添加管理员
	 * @param name  管理员名称
	 * @param password 管理员密码
	 * return 201 添加管理员成功
	 * @return 400 参数格式错误
	 * @return 409 管理员名称已存在
	 * @return 500 数据库内部错误
	 */
	public StatusCode put(String name,String password)throws SQLException;
	
	
	/**
	 * 用编号删除管理员
	 * @param id  管理员编号，不可缺省
	 * @return 200 删除管理员成功
	 * @return 400 参数格式错误
	 * @return 500 数据库内部错误
	 */
	public StatusCode delete(Integer id)throws SQLException;
	
	
	/**
	 * 用名称和密码删除管理员
	 * @param name  管理员名称
	 * @param password 管理员密码
	 * return 200 删除管理员成功
	 * @return 400 参数格式错误
	 * @return 403 管理员密码错误
	 * @return 404 管理员名称不存在
	 * @return 500 数据库内部错误
	 */
	public StatusCode delete(String name,String password)throws SQLException;
	
	
	
	/**
	 * 更新管理员信息
	 * @param id  管理员编号，不可缺省
	 * @param name 管理员名称，null表示不修改
	 * @param password	管理员密码，null表示不修改
	 * @return 201 修改成功
	 * @return 400 参数格式错误
	 * @return 403 拒绝修改
	 * @return 404 没有此id对应的管理员
	 */
	public StatusCode update(Integer id,String name,String password)throws SQLException;
	
	
	
	
}
