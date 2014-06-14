package com.vs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class VSMenu implements Serializable{

	int id;
	
	String mainMenu;
	
Set<VSSubmenu> vsSubmenus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Set<VSSubmenu> getVsSubmenus() {
		return vsSubmenus;
	}

	public void setVsSubmenus(Set<VSSubmenu> vsSubmenus) {
		this.vsSubmenus = vsSubmenus;
	}

	
	
	
}
