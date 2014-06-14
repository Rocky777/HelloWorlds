package com.vs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class VSSubmenu implements Serializable{

	private int id;
	
	private String subMenu;
	
	Set<VsSubmenuCatogarization> vsSubmenuCatogarizations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}

	public Set<VsSubmenuCatogarization> getVsSubmenuCatogarizations() {
		return vsSubmenuCatogarizations;
	}

	public void setVsSubmenuCatogarizations(
			Set<VsSubmenuCatogarization> vsSubmenuCatogarizations) {
		this.vsSubmenuCatogarizations = vsSubmenuCatogarizations;
	}

	
	
}
