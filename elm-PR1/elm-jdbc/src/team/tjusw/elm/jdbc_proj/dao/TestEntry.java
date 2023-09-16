package team.tjusw.elm.jdbc_proj.dao;

import java.sql.SQLException;
import java.util.List;

import team.tjusw.elm.jdbc_proj.dao.impl.BusinessDaoImpl;
import team.tjusw.elm.jdbc_proj.dao.impl.FoodDaoImpl;
import team.tjusw.elm.jdbc_proj.po.Business;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *	此类仅用于测试数据库接口
 * @author Abdusalam-Ablimit
 *
 */
@SuppressWarnings("unused")
public class TestEntry {
	public static void main(String[] args) {
		FoodDao dao = new FoodDaoImpl();
		BusinessDao dao2= new BusinessDaoImpl();
		try {
			//dao.update(7,	"麻公豆腐",	"麻苦味"	,233.00,	10002);
			System.out.println(dao2.update(10001, "万家饺子", "辽宁省沈阳市浑南区软件园E18楼1-121-3号", "好店", 9.0, 10.0, null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
