package team.tjusw.elmboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tjusw.elmboot.mapper.CartMapper;
import team.tjusw.elmboot.po.Cart;
import team.tjusw.elmboot.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	
	
	@Override
	public int saveCart(Cart cart) {
		return cartMapper.saveCart(cart);
	}
	

	@Override
	public int removeCart(Cart cart) {
		return cartMapper.removeCart(cart);
	}


	@Override
	public List<Cart> listCart(Cart cart) {
		return cartMapper.listCart(cart);
	}
	
	

	

	

	@Override
	public int updateCart(Cart cart) {
		return cartMapper.updateCart(cart);
	}

}
