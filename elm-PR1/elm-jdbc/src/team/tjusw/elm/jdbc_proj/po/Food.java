package team.tjusw.elm.jdbc_proj.po;

public class Food {
	private Integer id;
	private String name;
	private String explain;
	private Double price;
	private Integer businessId;

	public Food() {
		id = null;
		name = null;
		explain = null;
		price = null;
		businessId = null;
	}

	public Food(Integer id, String name, String explain, Double price, Integer businessId) {
		this.id = id;
		this.name = name;
		this.explain = explain;
		this.price = price;
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "\n食品编号：" + this.id + "\n食品名称：" + this.name + "\n食品介绍：" + this.explain + "\n食品价格：" + this.price
				+ "\n所属商家：" + this.businessId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

}