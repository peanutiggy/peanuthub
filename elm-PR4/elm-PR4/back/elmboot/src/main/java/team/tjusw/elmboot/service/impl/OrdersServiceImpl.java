package team.tjusw.elmboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.tjusw.elmboot.mapper.CartMapper;
import team.tjusw.elmboot.mapper.OrderDetailetMapper;
import team.tjusw.elmboot.mapper.OrdersMapper;
import team.tjusw.elmboot.po.Cart;
import team.tjusw.elmboot.po.OrderDetailet;
import team.tjusw.elmboot.po.Orders;
import team.tjusw.elmboot.service.OrdersService;
import team.tjusw.elmboot.util.CommonUtil;


@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderDetailetMapper orderDetailetMapper;

	@Override
	@Transactional
	public int createOrders(Orders orders) {
		// 1、查询当前用户购物车中当前商家的所有食品
		Cart cart = new Cart();
		cart.setUserId(orders.getUserId());
		cart.setBusinessId(orders.getBusinessId());
		List<Cart> cartList = cartMapper.listCart(cart);
		// 2、创建订单（返回生成的订单编号）
		orders.setOrderDate(CommonUtil.getCurrentDate());
		ordersMapper.saveOrders(orders);
		int orderId = orders.getOrderId();

		// 3、批量添加订单明细
		List<OrderDetailet> list = new ArrayList<>();
		for (Cart c : cartList) {
			OrderDetailet od = new OrderDetailet();
			od.setOrderId(orderId);
			od.setFoodId(c.getFoodId());
			od.setQuantity(c.getQuantity());
			list.add(od);
		}
		orderDetailetMapper.saveOrderDetailetBatch(list);

		// 4、从购物车表中删除相关食品信息
		cartMapper.removeCart(cart);

		return orderId;
	}

	

	
	

	@Override
	public List<Orders> listOrdersByUserId(String userId) {
		return ordersMapper.listOrdersByUserId(userId);
	}
	

	@Override
	public Orders getOrdersById(Integer orderId) {
		return ordersMapper.getOrdersById(orderId);
	}
}
