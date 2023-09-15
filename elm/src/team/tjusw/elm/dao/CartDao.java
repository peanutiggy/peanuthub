package team.tjusw.elm.dao;

import java.util.List;

import team.tjusw.elm.po.Cart;

public interface CartDao {
	public int saveCart(Cart cart) throws Exception;

	public int updateCart(Cart cart) throws Exception;

	public int removeCart(Cart cart) throws Exception;

	public List<Cart> listCart(Cart cart) throws Exception;

}
