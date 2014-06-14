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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="VSSubmenu")
public class VSSubmenuDAO implements Serializable{

	@Id
	@GeneratedValue
	int id;
	
	String subMenu;
	
	@OneToMany(targetEntity=VsSubmenuCatogarizationDAO.class)
	@CollectionOfElements
	@LazyCollection(LazyCollectionOption.FALSE)
	Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizations;

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

	public Set<VsSubmenuCatogarizationDAO> getVsSubmenuCatogarizations() {
		return vsSubmenuCatogarizations;
	}

	public void setVsSubmenuCatogarizations(
			Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizations) {
		this.vsSubmenuCatogarizations = vsSubmenuCatogarizations;
	}


	
}
