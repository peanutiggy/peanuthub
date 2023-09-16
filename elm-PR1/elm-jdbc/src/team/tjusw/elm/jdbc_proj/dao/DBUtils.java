package team.tjusw.elm.jdbc_proj.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 此类提供连接mysql数据库相关的操作
 * @author Abdusalam-Ablimit
 *
 */
public class DBUtils {
	private String url;
	private String userName;
	private String password;
	
	
	public DBUtils()
	{
		url = "jdbc:mysql://127.0.0.1:3306/elm1?serverTimezone=GMT&useSSL=false";
		userName = "root";
		password = "111111";
	}
	public DBUtils(String url,String userName,String password)
	{
		this.url = url;
		this.userName=userName;
		this.password = password;
	}
	public Connection getConnection() throws SQLException
	{
		Connection c = DriverManager.getConnection(url, userName, password);
		return c;
	}
	
}
