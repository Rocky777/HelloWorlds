package com.vs.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="VSsubmenuCatogarizations")
public class VsSubmenuCatogarizationDAO implements Serializable{

	@Id
	@GeneratedValue
	int id;
	
	String vsSubmenuCatogary;
	
	@OneToMany(targetEntity=VSProductAttributeDAO.class)
	@CollectionOfElements
	@LazyCollection(LazyCollectionOption.FALSE)
	Set<VSProductAttributeDAO> vsProductAttributeDAOs;
	
	public Set<VSProductAttributeDAO> getVsProductAttributeDAOs() {
		return vsProductAttributeDAOs;
	}

	public void setVsProductAttributeDAOs(
			Set<VSProductAttributeDAO> vsProductAttributeDAOs) {
		this.vsProductAttributeDAOs = vsProductAttributeDAOs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVsSubmenuCatogary() {
		return vsSubmenuCatogary;
	}

	public void setVsSubmenuCatogary(String vsSubmenuCatogary) {
		this.vsSubmenuCatogary = vsSubmenuCatogary;
	}
}
