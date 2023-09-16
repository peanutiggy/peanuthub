package team.tjusw.elm.jdbc_proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.tjusw.elm.jdbc_proj.dao.AdminDao;
import team.tjusw.elm.jdbc_proj.dao.DBUtils;
import team.tjusw.elm.jdbc_proj.dao.StatusCode;
import team.tjusw.elm.jdbc_proj.po.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin get(String name, String password)throws SQLException {
		if(name==null||password==null)
			return null;
		StringBuffer query = new StringBuffer("SELECT * FROM Admin WHERE name = \'" +name+"' AND password = \'" + password+"\'" );
		DBUtils dbu = new DBUtils();
		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		ResultSet rs = pst.executeQuery();
		Admin admin = new Admin();
		if(rs.next()){
			admin.setId(rs.getInt("id"));
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
			return admin;
		}
		con.close();
		return null;
	}

	@Override
	public List<Admin> get()throws SQLException {
		StringBuffer query = new StringBuffer("SELECT * FROM Admin");
		DBUtils dbu = new DBUtils();
		Connection con = dbu.getConnection();
		PreparedStatement pst = con.prepareStatement(query.toString());
		ResultSet rs = pst.executeQuery();
		List<Admin> lst = new ArrayList<Admin>(100);
		while (rs.next()) {
			lst.add(new Admin(rs.getInt("id"), rs.getString("name"), rs.getString("password")));
		}
		con.close();
		return lst;
	}

	@Override
	public StatusCode put(String name, String password)  throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusCode delete (Integer id)throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusCode delete(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusCode update(Integer id, String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
