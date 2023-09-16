package team.tjusw.elm.jdbc_proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.tjusw.elm.jdbc_proj.dao.DBUtils;
import team.tjusw.elm.jdbc_proj.dao.FoodDao;
import team.tjusw.elm.jdbc_proj.dao.StatusCode;
import team.tjusw.elm.jdbc_proj.po.Food;

public class FoodDaoImpl implements FoodDao {

	@Override
	public List<Food> get(Integer id, String name, String explain, Double minPrice, Double maxPrice, Integer businessId)
			throws SQLException {
		StringBuffer query = new StringBuffer("SELECT * FROM Food WHERE 1=1");
		if (id != null)
			query.append(" AND id = " + id);
		if (name != null)
			query.append(" AND `name` like '%" + name + "%'");
		if (explain != null)
			query.append(" AND `explain` like '%" + explain + "%'");
		if (minPrice != null)
			query.append(" AND Price >= " + minPrice);
		if (maxPrice != null)
			query.append(" AND Price <= " + maxPrice);
		if (businessId != null)
			query.append(" AND businessId = " + businessId);

		DBUtils dbu = new DBUtils();
		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		ResultSet rs = pst.executeQuery();
		List<Food> lst = new ArrayList<Food>(100);
		while (rs.next()) {
			lst.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getString("explain"), rs.getDouble("Price"),
					rs.getInt("businessId")));
		}
		con.close();
		return lst;
	}

	@Override
	public StatusCode put(String name, String explain, Double price, Integer businessId) throws SQLException {
		if (name == null)
			return StatusCode.BAD_REQUEST;
		StringBuffer query = new StringBuffer("INSERT INTO Food(");
		StringBuffer par = new StringBuffer(" VALUES(");

		if (explain != null) {
			query.append("`explain`,");
			par.append("\'" + explain + "\',");
		}
		if (price != null) {
			query.append("Price,");
			par.append("" + price + ",");
		}
		if (businessId != null) {
			query.append("businessId,");
			par.append("" + businessId + ",");
		}

		query.append("`name`)");
		par.append("\'" + name + "\')");
		query.append(par);

		DBUtils dbu = new DBUtils();
		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		int n = pst.executeUpdate();
		if (n == 1)
			return StatusCode.CREATED;
		else
			throw new SQLException("插入已完成，但受影响的行数大于1");

	}

	@Override
	public StatusCode put(Food food) throws SQLException {
		// TODO Auto-generated method stub
		return this.put(food.getName(), food.getExplain(), food.getPrice(), food.getBusinessId());
	}

	
	
	@Override
	public StatusCode delete(Integer id) throws SQLException {
		List<Food> ls = this.get(id, null, null, null, null, null);
		if (ls == null)
			throw new SQLException("数据库系统错误");
		else if (ls.size() == 0)
			return StatusCode.NOT_FOUND;
		else {
			String query = "DELETE FROM Food WHERE id = " + id;
			DBUtils dbu = new DBUtils();
			Connection con = dbu.getConnection();
			PreparedStatement pst = con.prepareStatement(query.toString());
			int n = pst.executeUpdate();
			if (n == 1)
				return StatusCode.OK;
			else
				throw new SQLException("删除已完成，但受影响的行数大于1");
		}
	}

	@Override
	public StatusCode update(Integer id, String name, String explain, Double price, Integer businessId)
			throws SQLException {
		if (id == null || (name == null && explain == null && price == null && businessId == null))
			return StatusCode.BAD_REQUEST;
		StringBuffer query = new StringBuffer("UPDATE Food SET ");
		if (name != null)
			query.append("`name` = \'" + name + "\',");
		if (explain != null)
			query.append("`explain` = \'" + explain + "\',");
		if (price != null)
			query.append("price = " + price + ",");
		if (businessId != null)
			query.append("businessId = " + businessId + ",");

		query.deleteCharAt(query.length() - 1);
		query.append(" WHERE id = " + id);
		DBUtils dbu = new DBUtils();

		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		int n = pst.executeUpdate();
		if (n == 1)
			return StatusCode.OK;
		else
			throw new SQLException("更新已完成，但受影响的行数大于1");

	}


	@Override
	public StatusCode update(Food food) throws SQLException {
		return this.update(food.getId(),food.getName(),food.getExplain(),food.getPrice(),food.getBusinessId());
	}

}
