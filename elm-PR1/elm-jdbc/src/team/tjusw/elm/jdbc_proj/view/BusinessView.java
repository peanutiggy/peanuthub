package team.tjusw.elm.jdbc_proj.view;

import team.tjusw.elm.jdbc_proj.po.Business;

public interface BusinessView {
	public void listBusinessAll();
	public void listBusiness();
	public void saveBusiness();
	public void removeBusiness();
	public Business login();
	public void showBusiness(Integer businessId);
	public void editBusiness(Integer businessId);
	public void updateBussinessPassword(Integer businessId);
}

