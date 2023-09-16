package team.tjusw.elm.jdbc_proj.po;

public class Business {
	 private Integer id;
	 private String password;
	 private String name;
	 private String address;
	 private String explain;
	 private Double startPrice;
	 private Double deliveryPrice;
	 
	 public Business(Integer id,String password,String name,String address,String explain,Double startPrice,Double deliveryPrice)
	 {
		 this.id = id;
		 this.password = password;
		 this.name = name;
		 this.address = address;
		 this.explain = explain;
		 this.startPrice = startPrice;
		 this.deliveryPrice = deliveryPrice;
	 }
	 
	 
	 
	 @Override
	 public String toString() {
	 return "\n商家编号："+this.id+
	 "\n商家名称："+this.name+
	 "\n商家地址："+this.address+
	 "\n商家介绍："+this.explain+
	 "\n起送费：¥"+this.startPrice+
	 "\n配送费：¥"+this.deliveryPrice+"\n";
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Double getStarPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	 
	}
