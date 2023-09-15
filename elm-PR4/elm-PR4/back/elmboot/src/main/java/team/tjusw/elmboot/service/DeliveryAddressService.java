package team.tjusw.elmboot.service;

import java.util.List;

import team.tjusw.elmboot.po.DeliveryAddress;

public interface DeliveryAddressService {
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

	public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

	public int removeDeliveryAddress(Integer daId);

	public DeliveryAddress getDeliveryAddressById(Integer daId);

	
}
