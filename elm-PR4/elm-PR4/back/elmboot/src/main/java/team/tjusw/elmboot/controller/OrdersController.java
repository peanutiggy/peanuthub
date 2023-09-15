package team.tjusw.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.tjusw.elmboot.po.Orders;
import team.tjusw.elmboot.service.OrdersService;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@RequestMapping("/listOrdersByUserId")
	public List<Orders> listOrdersByUserId(Orders orders) throws Exception {
		return ordersService.listOrdersByUserId(orders.getUserId());
	}
	

	@RequestMapping("/createOrders")
	public int createOrders(Orders orders) throws Exception {
		return ordersService.createOrders(orders);
	}

	@RequestMapping("/getOrdersById")
	public Orders getOrdersById(Orders orders) throws Exception {
		return ordersService.getOrdersById(orders.getOrderId());
	}
}
