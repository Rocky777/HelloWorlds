package com.vs.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="VSMainMenu")
public class VSMenuDAO implements Serializable{

	@Id
	@GeneratedValue
	int id;
	
	String mainMenu;
	
	@OneToMany(targetEntity=VSSubmenuDAO.class,fetch=FetchType.EAGER)
	@CollectionOfElements
	Set<VSSubmenuDAO> vsSubmenus;

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

	public Set<VSSubmenuDAO> getVsSubmenus() {
		return vsSubmenus;
	}

	public void setVsSubmenus(Set<VSSubmenuDAO> vsSubmenus) {
		this.vsSubmenus = vsSubmenus;
	}


	
	
}
