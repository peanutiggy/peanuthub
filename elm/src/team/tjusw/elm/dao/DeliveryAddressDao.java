package team.tjusw.elm.dao;

import java.util.List;

import team.tjusw.elm.po.DeliveryAddress;

public interface DeliveryAddressDao {
	 public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception;
	 public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception;
	 public int removeDeliveryAddress(Integer daId) throws Exception;
	 public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception;
	 public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception;
	 
}
