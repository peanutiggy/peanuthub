package team.tjusw.elm.jdbc_proj.po;

public class Admin {
	private Integer id;
	private String name;
	private String password;

	@Override
	public String toString() {
		return "管理员编号: " + this.id + "\n管理员名称: " + this.name + "\n管理员密码: " + this.password;

	}

	public Integer getId() {
		return id;
	}

	public Admin(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
