package team.tjusw.elm.jdbc_proj.dao.impl;

import java.util.ArrayList;
import java.util.List;

import team.tjusw.elm.jdbc_proj.dao.BusinessDao;
import team.tjusw.elm.jdbc_proj.dao.DBUtils;
import team.tjusw.elm.jdbc_proj.dao.StatusCode;
import team.tjusw.elm.jdbc_proj.po.Business;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessDaoImpl implements BusinessDao {

	@Override
	public List<Business> get(Integer id, String name, String address, String explain, Double startPrice,
			Double deliveryPrice) throws SQLException {
		StringBuffer query = new StringBuffer("SELECT * FROM Business WHERE 1=1");
		if (id != null)
			query.append(" AND id = " + id);
		if (name != null)
			query.append(" AND `name` like \'%" + name + "%\'");
		if (address != null)
			query.append(" AND address like \'%" + address + "%\'");
		if (explain != null)
			query.append(" AND `explain` like \'%" + explain + "%\'");
		if (startPrice != null)
			query.append(" AND startPrice <= " + startPrice);
		if (deliveryPrice != null)
			query.append(" AND deliveryPrice <= " + deliveryPrice);
		
		DBUtils dbu = new DBUtils();
		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		ResultSet rs = pst.executeQuery();
		List<Business> lst = new ArrayList<Business>(100);
		while (rs.next()) {
			lst.add(new Business(rs.getInt("id"), rs.getString("password"), rs.getString("name"),
					rs.getString("address"), rs.getString("explain"), rs.getDouble("startPrice"),
					rs.getDouble("deliveryPrice")));
		}
		con.close();
		return lst;

	}

	@Override
	public Business get(Integer id, String password) throws SQLException {
		// TODO Auto-generated method stub
		List<Business> lst = this.get(id, null, null, null, null, null);
		if (lst == null)
			throw new SQLException("数据库系统错误");
		else if (lst.isEmpty())
			return null;
		else if (lst.get(0).getPassword().equals(password))
			return lst.get(0);
		else
			return null;
	}

	@Override
	public StatusCode delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		List<Business> ls = this.get(id, null, null, null, null, null);
		if (ls == null)
			throw new SQLException("数据库系统错误");
		else if (ls.size() == 0)
			return StatusCode.NOT_FOUND;
		else {
			String query = "DELETE FROM Business WHERE id = " + id;
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
	public StatusCode put(String name, String address, String explain, Double startPrice, Double deliveryPrice, String password)
			throws SQLException {
		if (name == null)
			return StatusCode.BAD_REQUEST;
		StringBuffer query = new StringBuffer("INSERT INTO Business(");
		StringBuffer par = new StringBuffer(" VALUES(");

		if (address != null) {
			query.append("address,");
			par.append("\'" + address + "\',");
		}
		if (explain != null) {
			query.append("`explain`,");
			par.append("\'" + explain + "\',");
		}
		if (startPrice != null) {
			query.append("startPrice,");
			par.append("" + startPrice + ",");
		}
		if (deliveryPrice != null) {
			query.append("deliveryPrice,");
			par.append("" + deliveryPrice + ",");
		}

		query.append("`name`,`password`)");
		par.append("\'" + name + "\',\'"+password+"\')");
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
	public StatusCode update(Integer id, String name, String address, String explain, Double startPrice,
			Double deliveryPrice,String password) throws SQLException {
		// TODO Auto-generated method stub
		if (id == null
				|| (name == null && address == null && explain == null && startPrice == null && deliveryPrice == null&& password == null))
			return StatusCode.BAD_REQUEST;
		StringBuffer query = new StringBuffer("UPDATE Business SET ");
		if (name != null)
			query.append("`name` = \'" + name + "\',");
		if (address != null)
			query.append("`address` = \'" + address + "\',");
		if (explain != null)
			query.append("`explain` = \'" + explain + "\',");
		if (startPrice != null)
			query.append("startPrice = " + startPrice + ",");
		if (deliveryPrice != null)
			query.append("deliveryPrice = " + deliveryPrice + ",");
		if (password != null)
			query.append("`password` = \'" + password + "\',");
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

}
